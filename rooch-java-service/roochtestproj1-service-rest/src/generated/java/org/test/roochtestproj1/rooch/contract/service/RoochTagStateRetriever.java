// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract.service;

import com.github.wubuku.rooch.bean.GetAnnotatedStatesResponseMoveStructItem;
import com.github.wubuku.rooch.utils.RoochJsonRpcClient;
import org.test.roochtestproj1.domain.tag.*;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.rooch.contract.DomainBeanUtils;
import org.test.roochtestproj1.rooch.bcs.BcsDomainBeanUtils;
import org.test.roochtestproj1.rooch.contract.Tag;

import java.util.*;
import java.math.*;
import java.util.function.*;

public class RoochTagStateRetriever {

    private RoochJsonRpcClient roochJsonRpcClient;

    private Function<String, TagState.MutableTagState> tagStateFactory;


    public RoochTagStateRetriever(RoochJsonRpcClient roochJsonRpcClient,
                                    Function<String, TagState.MutableTagState> tagStateFactory
    ) {
        this.roochJsonRpcClient = roochJsonRpcClient;
        this.tagStateFactory = tagStateFactory;
    }

    public TagState retrieveTagState(String objectId) {
        List<GetAnnotatedStatesResponseMoveStructItem<Tag.MoveObject>> getObjectListResponse = roochJsonRpcClient.getMoveStructAnnotatedStates(
                "/object/" + com.github.wubuku.rooch.utils.HexUtils.formatHex(objectId),
                Tag.MoveObject.class
        );
        if (getObjectListResponse.size() == 0) {
            return null;
        }
        Tag.MoveObject tag = getObjectListResponse.get(0).getMoveValue().getValue();
        return toTagState(tag);
    }

    private TagState toTagState(Tag.MoveObject tagObj) {
        Tag tag = tagObj.getValue().getValue();
        TagState.MutableTagState tagState = tagStateFactory.apply(tag.getName());
        tagState.setId_(tagObj.getId());
        tagState.setVersion(tag.getVersion());
        return tagState;
    }

}

