package itakademija.java2015.ui.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import itakademija.java2015.jpa.assigment1.entities.Author;
import itakademija.java2015.jpa.assigment1.entities.AuthorTag;
import itakademija.java2015.jpa.assigment1.entities.repositories.AuthorRepository;

/**
 * This class controls behavior of Author list page. Reacts to user commands and
 * handles navigation
 *
 */
public class AuthorsListPageBean {
	private static final String NAV_SHOW_AUTHORS_BY_TAG = "show-tags";

	static final Logger log = LoggerFactory.getLogger(AuthorsListPageBean.class);

	/**
	 * Navigation outcomes
	 */
	public static final String NAV_SHOW_ADD_BOOK = "show-add-book";
	public static final String NAV_LIST_AUTHORS = "list-authors";

	/**
	 * This class holds user-input data. Basically it is just container. This
	 * class is responsible JUST FOR HOLDING ANY DATA in session
	 *
	 */
	public static class AuthorsListPageData implements Serializable {

		private static final long serialVersionUID = -7847613490719023414L;

		/**
		 * Holds data of new Author form fields
		 */
		@Valid
		
		private Author newAuthor;

		/**
		 * Holds data for currently selected author
		 */
		@Valid
		private Author currentAuthor;

		private String tags;
		
		private String searchTag;
		
		private List<Author> foundAuthors;

		/**
		 * Initialization method for bean (called after bean is created)
		 */
		public void init() {
			newAuthor = new Author();
			foundAuthors = new ArrayList<>();
		}

		public String getSearchTag() {
			return searchTag;
		}

		public void setSearchTag(String searchTag) {
			this.searchTag = searchTag;
		}

		public List<Author> getFoundAuthors() {
			return foundAuthors;
		}

		public void setFoundAuthors(List<Author> foundAuthors) {
			this.foundAuthors = foundAuthors;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public Author getCurrentAuthor() {
			return currentAuthor;
		}

		public void setCurrentAuthor(Author currentAuthor) {
			this.currentAuthor = currentAuthor;
		}

		public Author getNewAuthor() {
			return newAuthor;
		}

		public void setNewAuthor(Author newAuthor) {
			this.newAuthor = newAuthor;
		}
	} // end of AuthorsListPageData

	/**
	 * Data container/holder
	 */
	private AuthorsListPageData data;

	/**
	 * repositories
	 */
	private AuthorRepository authorRepo;

	/**
	 * Add new author to DB as it was entered in form
	 * 
	 * @return JSF outcome
	 */
	public String addNew() {
		String tagsString = data.getTags();
		if (tagsString != null) {
			List<AuthorTag> tagList = convertTagStringToTagList(tagsString);

			data.newAuthor.setTags(tagList);
		}
		authorRepo.save(data.newAuthor);
		data.newAuthor = new Author(); // clear the form values
		data.tags = "";
		return NAV_LIST_AUTHORS;
	}
	public String convertTagListToTagString(List<AuthorTag> tags) {
		String ret = "";
		for (AuthorTag tag: tags) {
			ret += tag.getTag() + " ";
		}
		return ret;
	}
	private List<AuthorTag> convertTagStringToTagList(String tagsString) {
		log.debug("Converting string[{}]", tagsString);
		List<AuthorTag> tagList = new ArrayList<>();

		if (tagsString != null) {
			/**
			 * This splits string at any sequence of blanks (spaces, tabs, ...) and returns chopped list of strings
			 */
			String[] res = tagsString.split("\\s+");
			log.debug("Split size: {}", res.length);
			List<String> tagsArray = Arrays.asList(res);
			log.debug("List size:{}", tagsArray.size());
			for (String tagStr : tagsArray) {
				AuthorTag t = null;
				t = authorRepo.findTag(tagStr);
				if (t == null)
				{
					log.debug("New tag: {}", tagStr);
					t = new AuthorTag();
					t.setCreatedOn(new Date());
				}
				else
					log.debug("Existing tag: {}", tagStr);
				log.debug("Adding single tag: [{}]", tagStr);
				t.setTag(tagStr);
				tagList.add(t);
			}
		}
		return tagList;
	}

	/**
	 * Delete selected author
	 * 
	 * @param author
	 * @return JSF outcome
	 */
	public String deleteSelected(Author author) {
		if (author == null)
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Author being deleted is null?"));
		else {
			if (author.getName().equalsIgnoreCase("Jonas"))
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "You are deleting Jonas!"));
			authorRepo.delete(author);
		}
		return NAV_LIST_AUTHORS;
	}

	/**
	 * This method just remembers selected author and redirects user to new page
	 */
	public String showAddBookPage(Author a) {
		log.debug("Will store selected author for later access in Add new Book form: {}", a);
		data.currentAuthor = a;
		return NAV_SHOW_ADD_BOOK;
	}

	public String searchTags() {
		//save to session
		data.foundAuthors = authorRepo.findAllAuthorsByTag(data.getSearchTag());
		return NAV_SHOW_AUTHORS_BY_TAG;
	}
	public AuthorsListPageData getData() {
		return data;
	}

	public void setData(AuthorsListPageData data) {
		this.data = data;
	}

	public AuthorRepository getAuthorRepo() {
		return authorRepo;
	}

	public void setAuthorRepo(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;

	}

	public List<Author> getAuthorList() {
		return authorRepo.findAll();
	}
}
