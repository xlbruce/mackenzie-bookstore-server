package api.google.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBooksApiResponse {
	
	private List<Item> items;
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Item {
		
		private VolumeInfo volumeInfo;
		
		public Item() {}
		
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class VolumeInfo {
			
			private String title;
			
			public String getSubtitle() {
				return subtitle;
			}

			public void setSubtitle(String subtitle) {
				this.subtitle = subtitle;
			}

			public List<String> getAuthors() {
				return authors;
			}

			public void setAuthors(List<String> authors) {
				this.authors = authors;
			}

			public String getPublisher() {
				return publisher;
			}

			public void setPublisher(String publisher) {
				this.publisher = publisher;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public List<IndustryIdentifiers> getIndustryIdentifiers() {
				return industryIdentifiers;
			}

			public void setIndustryIdentifiers(List<IndustryIdentifiers> industryIdentifiers) {
				this.industryIdentifiers = industryIdentifiers;
			}

			public ImageLinks getImageLinks() {
				return imageLinks;
			}

			public void setImageLinks(ImageLinks imageLinks) {
				this.imageLinks = imageLinks;
			}

			private String subtitle;
			
			private List<String> authors;
			
			private String publisher;

			private String description;
			
			private List<IndustryIdentifiers> industryIdentifiers;
			
			private ImageLinks imageLinks;
			
			public VolumeInfo() {}
			
			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			@JsonIgnoreProperties(ignoreUnknown = true)
			static class ImageLinks {
				
				private String thumbnail;
				
				public ImageLinks() {}

				public String getThumbnail() {
					return thumbnail;
				}

				public void setThumbnail(String thumbnail) {
					this.thumbnail = thumbnail;
				}
			}
			
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class IndustryIdentifiers {
				
				private String type;
				
				private String identifier;
				
				public IndustryIdentifiers() {}

				public String getType() {
					return type;
				}

				public void setType(String type) {
					this.type = type;
				}

				public String getIdentifier() {
					return identifier;
				}

				public void setIdentifier(String identifier) {
					this.identifier = identifier;
				} 
			}
			
		}

		public VolumeInfo getVolumeInfo() {
			return volumeInfo;
		}

		public void setVolumeInfo(VolumeInfo volumeInfo) {
			this.volumeInfo = volumeInfo;
		}
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
