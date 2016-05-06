package api.google.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.google.model.GoogleBooksApiResponse;
import api.google.model.GoogleBooksApiResponse.Item;
import api.google.model.GoogleBooksApiResponse.Item.VolumeInfo;
import model.entities.Author;
import model.entities.Book;
import model.entities.Publisher;

public class GoogleBooksApiClient {

	private HttpClient client = HttpClientBuilder.create().build();

	private static final String BOOKS_API_URL = "https://www.googleapis.com/books/v1/volumes?q=%s";

	public List<Book> searchBooks(String searchKey) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(String.format(BOOKS_API_URL, searchKey.replaceAll(" ", "%20")));
		HttpResponse response = client.execute(request);
		ObjectMapper mapper = new ObjectMapper();
		List<Book> books;

		String responseStr = IOUtils.toString(response.getEntity().getContent());
		GoogleBooksApiResponse bookResponse = mapper.readValue(responseStr, GoogleBooksApiResponse.class);

		books = parseAndFilterBook(bookResponse);

		return books;
	}

	private List<Book> parseAndFilterBook(GoogleBooksApiResponse bookResponse) {
		List<Book> books = new ArrayList<>();

		//TODO check this
		Stream<Item> filter = bookResponse.getItems().stream()
				.filter(t -> t.getVolumeInfo().getIndustryIdentifiers().get(0).getType().equals("ISBN_13"));

		filter.iterator().forEachRemaining(item -> {
			VolumeInfo volumeInfo = item.getVolumeInfo();

			Book book = new Book();
			Author author = new Author();
			Publisher publisher = new Publisher();

			String title = volumeInfo.getTitle();
			String authorStr;
			if (volumeInfo.getAuthors() != null) {
				authorStr = volumeInfo.getAuthors().get(0);
			} else {
				authorStr = "Desconhecido";
			}
			
			// Some descriptions are null
			String description = volumeInfo.getDescription() != null ? volumeInfo.getDescription() : title;
			String publisherStr = volumeInfo.getPublisher();
			String isbn = volumeInfo.getIndustryIdentifiers().get(0).getIdentifier();

			author.setName(authorStr);
			publisher.setName(publisherStr);

			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setDescription(description);
			book.setName(title);
			book.setIsbn(isbn);

			books.add(book);
		});

		return books;
	}
}
