// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.article;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.specialization.*;


public class ReferenceStateDto {

    private BigInteger referenceNumber;

    public BigInteger getReferenceNumber()
    {
        return this.referenceNumber;
    }

    public void setReferenceNumber(BigInteger referenceNumber)
    {
        this.referenceNumber = referenceNumber;
    }

    private String title;

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    private String author;

    public String getAuthor()
    {
        return this.author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    private BigInteger publicationYear;

    public BigInteger getPublicationYear()
    {
        return this.publicationYear;
    }

    public void setPublicationYear(BigInteger publicationYear)
    {
        this.publicationYear = publicationYear;
    }

    private String publisher;

    public String getPublisher()
    {
        return this.publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    private String doi;

    public String getDoi()
    {
        return this.doi;
    }

    public void setDoi(String doi)
    {
        this.doi = doi;
    }

    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    private BigInteger pageNumber;

    public BigInteger getPageNumber()
    {
        return this.pageNumber;
    }

    public void setPageNumber(BigInteger pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long offChainVersion;

    public Long getOffChainVersion()
    {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion)
    {
        this.offChainVersion = offChainVersion;
    }

    private String articleId;

    public String getArticleId()
    {
        return this.articleId;
    }

    public void setArticleId(String articleId)
    {
        this.articleId = articleId;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ReferenceStateDto[] toReferenceStateDtoArray(Iterable<ReferenceState> states) {
            return toReferenceStateDtoList(states).toArray(new ReferenceStateDto[0]);
        }

        public List<ReferenceStateDto> toReferenceStateDtoList(Iterable<ReferenceState> states) {
            ArrayList<ReferenceStateDto> stateDtos = new ArrayList();
            for (ReferenceState s : states) {
                ReferenceStateDto dto = toReferenceStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public ReferenceStateDto toReferenceStateDto(ReferenceState state)
        {
            if(state == null) {
                return null;
            }
            ReferenceStateDto dto = new ReferenceStateDto();
            if (returnedFieldsContains("ReferenceNumber")) {
                dto.setReferenceNumber(state.getReferenceNumber());
            }
            if (returnedFieldsContains("Title")) {
                dto.setTitle(state.getTitle());
            }
            if (returnedFieldsContains("Author")) {
                dto.setAuthor(state.getAuthor());
            }
            if (returnedFieldsContains("PublicationYear")) {
                dto.setPublicationYear(state.getPublicationYear());
            }
            if (returnedFieldsContains("Publisher")) {
                dto.setPublisher(state.getPublisher());
            }
            if (returnedFieldsContains("Doi")) {
                dto.setDoi(state.getDoi());
            }
            if (returnedFieldsContains("Url")) {
                dto.setUrl(state.getUrl());
            }
            if (returnedFieldsContains("PageNumber")) {
                dto.setPageNumber(state.getPageNumber());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OffChainVersion")) {
                dto.setOffChainVersion(state.getOffChainVersion());
            }
            if (returnedFieldsContains("ArticleId")) {
                dto.setArticleId(state.getArticleId());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}
