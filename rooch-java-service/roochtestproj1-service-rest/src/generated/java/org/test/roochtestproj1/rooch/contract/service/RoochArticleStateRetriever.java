// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.service;

import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponseMoveStructItem;
import com.github.wubuku.rooch.utils.RoochJsonRpcClient;
import org.test.roochtestproj1.domain.article.*;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.rooch.contract.DomainBeanUtils;
import org.test.roochtestproj1.rooch.bcs.BcsDomainBeanUtils;
import org.test.roochtestproj1.rooch.contract.Article;
import org.test.roochtestproj1.rooch.contract.Reference;

import java.util.*;
import java.math.*;
import java.util.function.*;

public class RoochArticleStateRetriever {

    private RoochJsonRpcClient roochJsonRpcClient;

    private Function<String, ArticleState.MutableArticleState> articleStateFactory;

    private BiFunction<ArticleState, BigInteger, ReferenceState.MutableReferenceState> referenceStateFactory;

    private ReferenceReferenceNumbersGetter referenceReferenceNumbersGetter;


    public RoochArticleStateRetriever(RoochJsonRpcClient roochJsonRpcClient,
                                    Function<String, ArticleState.MutableArticleState> articleStateFactory,
                                    BiFunction<ArticleState, BigInteger, ReferenceState.MutableReferenceState> referenceStateFactory,
                                    ReferenceReferenceNumbersGetter referenceReferenceNumbersGetter
    ) {
        this.roochJsonRpcClient = roochJsonRpcClient;
        this.articleStateFactory = articleStateFactory;
        this.referenceStateFactory = referenceStateFactory;
        this.referenceReferenceNumbersGetter = referenceReferenceNumbersGetter;
    }

    public ArticleState retrieveArticleState(String objectId) {
        List<GetAnnotatedStatesResponseMoveStructItem<Article.MoveObject>> getObjectListResponse = roochJsonRpcClient.getMoveStructAnnotatedStates(
                "/object/" + com.github.wubuku.rooch.utils.HexUtils.formatHex(objectId),
                Article.MoveObject.class
        );
        if (getObjectListResponse.size() == 0) {
            return null;
        }
        Article.MoveObject article = getObjectListResponse.get(0).getMoveValue().getValue();
        return toArticleState(article);
    }

    private ArticleState toArticleState(Article.MoveObject articleObj) {
        Article article = articleObj.getValue().getValue();
        ArticleState.MutableArticleState articleState = articleStateFactory.apply(articleObj.getId());
        articleState.setVersion(article.getVersion());
        articleState.setTitle(article.getTitle());
        articleState.setAuthor(article.getAuthor());
        articleState.setContent(article.getContent());
        articleState.setTags(new HashSet<>(Arrays.asList(article.getTags())));
        if (article.getReferences() != null) {
            String referenceTableHandle = article.getReferences().getValue().getHandle();
            List<Reference> references = getReferences(referenceTableHandle, referenceReferenceNumbersGetter.getReferenceReferenceNumbers(articleState.getId()));
            for (Reference i : references) {
                articleState.getReferences().add(toReferenceState(articleState, i));
            }
        }

        return articleState;
    }

    private ReferenceState toReferenceState(ArticleState articleState, Reference reference) {
        ReferenceState.MutableReferenceState referenceState = referenceStateFactory.apply(articleState, reference.getReferenceNumber());
        referenceState.setTitle(reference.getTitle());
        referenceState.setAuthor(reference.getAuthor());
        referenceState.setPublicationYear(reference.getPublicationYear().getValue().getVec().length == 0 ? null : reference.getPublicationYear().getValue().getVec()[0]);
        referenceState.setPublisher(reference.getPublisher().getValue().getVec().length == 0 ? null : reference.getPublisher().getValue().getVec()[0]);
        referenceState.setDoi(reference.getDoi().getValue().getVec().length == 0 ? null : reference.getDoi().getValue().getVec()[0]);
        referenceState.setUrl(reference.getUrl().getValue().getVec().length == 0 ? null : reference.getUrl().getValue().getVec()[0]);
        referenceState.setPageNumber(reference.getPageNumber().getValue().getVec().length == 0 ? null : reference.getPageNumber().getValue().getVec()[0]);
        return referenceState;
    }

    private List<Reference> getReferences(String referenceTableHandle, List<BigInteger> referenceNumbers) {
        List<Reference> references = new ArrayList<>();

        for (BigInteger referenceNumber : referenceNumbers) {
            String key = com.github.wubuku.rooch.utils.HexUtils.byteArrayToHexWithPrefix(com.github.wubuku.rooch.bcs.BcsUtils.serializeU64(referenceNumber.longValue()));
            List<GetAnnotatedStatesResponseMoveStructItem<Reference>> getReferenceTableItemResponse = roochJsonRpcClient
                    .getMoveStructAnnotatedStates("/table/" + com.github.wubuku.rooch.utils.HexUtils.formatHex(referenceTableHandle) + "/" + key, Reference.class);
            if (getReferenceTableItemResponse.size() == 1 && getReferenceTableItemResponse.get(0) != null) {
                references.add(getReferenceTableItemResponse.get(0).getMoveValue().getValue());
            }
        }
        return references;
    }

    public interface ReferenceReferenceNumbersGetter {
        List<BigInteger> getReferenceReferenceNumbers(String articleId);
    }

}

