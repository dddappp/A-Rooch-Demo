// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.rooch.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.rooch.bean.*;
import java.math.BigInteger;

public class ReferenceVO extends AnnotatedMoveStructView<ReferenceVO.ReferenceVOValue> {

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class ReferenceVOValue {
        private BigInteger referenceNumber;

        private String title;

        private com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> url;


        public BigInteger getReferenceNumber() {
            return referenceNumber;
        }

        public void setReferenceNumber(BigInteger referenceNumber) {
            this.referenceNumber = referenceNumber;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> getUrl() {
            return url;
        }

        public void setUrl(com.github.wubuku.rooch.bean.AnnotatedMoveOptionView<String> url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ReferenceVOValue{" +
                    "referenceNumber=" + referenceNumber +
                    ", title=" + '\'' + title + '\'' +
                    ", url=" + url +
                    '}';
        }
    }
}

