// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.article;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.test.roochtestproj1.rooch.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ArticleCreated {
    private com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> id;

    private String title;

    private String author;

    private String content;

    private ReferenceVO[] references;

    private String[] tags;

    private String owner;

    public com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> getId() {
        return id;
    }

    public void setId(com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReferenceVO[] getReferences() {
        return references;
    }

    public void setReferences(ReferenceVO[] references) {
        this.references = references;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "ArticleCreated{" +
                "id='" + id + '\'' +
                ", title=" + '\'' + title + '\'' +
                ", author=" + '\'' + author + '\'' +
                ", content=" + '\'' + content + '\'' +
                ", references=" + Arrays.toString(references) +
                ", tags=" + Arrays.toString(tags) +
                ", owner=" + '\'' + owner + '\'' +
                '}';
    }

}
