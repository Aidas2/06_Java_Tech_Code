package itakademija.java2015.jpa.assigment1.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Table;

@Table(name="AUTHOR")
@DiscriminatorValue("F")
public class FictionOnlyAuthor extends Author {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2161590463566713623L;
	private String nickNameInFictionCommunity;

	public String getNickNameInFictionCommunity() {
		return nickNameInFictionCommunity;
	}

	public void setNickNameInFictionCommunity(String nickNameInFictionCommunity) {
		this.nickNameInFictionCommunity = nickNameInFictionCommunity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nickNameInFictionCommunity == null) ? 0 : nickNameInFictionCommunity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof FictionOnlyAuthor)) {
			return false;
		}
		FictionOnlyAuthor other = (FictionOnlyAuthor) obj;
		if (nickNameInFictionCommunity == null) {
			if (other.nickNameInFictionCommunity != null) {
				return false;
			}
		} else if (!nickNameInFictionCommunity.equals(other.nickNameInFictionCommunity)) {
			return false;
		}
		return true;
	}
	
}
