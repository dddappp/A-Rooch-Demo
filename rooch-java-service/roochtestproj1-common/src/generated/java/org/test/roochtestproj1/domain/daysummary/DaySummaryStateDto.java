// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.daysummary;

import java.util.*;
import java.math.*;
import org.test.roochtestproj1.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.specialization.*;


public class DaySummaryStateDto {

    private Day day;

    public Day getDay()
    {
        return this.day;
    }

    public void setDay(Day day)
    {
        this.day = day;
    }

    private String id_;

    public String getId_()
    {
        return this.id_;
    }

    public void setId_(String id)
    {
        this.id_ = id;
    }

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String metadata;

    public String getMetadata()
    {
        return this.metadata;
    }

    public void setMetadata(String metadata)
    {
        this.metadata = metadata;
    }

    private String optionalData;

    public String getOptionalData()
    {
        return this.optionalData;
    }

    public void setOptionalData(String optionalData)
    {
        this.optionalData = optionalData;
    }

    private BigInteger version;

    public BigInteger getVersion()
    {
        return this.version;
    }

    public void setVersion(BigInteger version)
    {
        this.version = version;
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

    private String[] arrayData;

    public String[] getArrayData() {
        return this.arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    private Integer[] u16ArrayData;

    public Integer[] getU16ArrayData() {
        return this.u16ArrayData;
    }

    public void setU16ArrayData(Integer[] u16ArrayData) {
        this.u16ArrayData = u16ArrayData;
    }

    private Long[] u32ArrayData;

    public Long[] getU32ArrayData() {
        return this.u32ArrayData;
    }

    public void setU32ArrayData(Long[] u32ArrayData) {
        this.u32ArrayData = u32ArrayData;
    }

    private BigInteger[] u64ArrayData;

    public BigInteger[] getU64ArrayData() {
        return this.u64ArrayData;
    }

    public void setU64ArrayData(BigInteger[] u64ArrayData) {
        this.u64ArrayData = u64ArrayData;
    }

    private BigInteger[] u128ArrayData;

    public BigInteger[] getU128ArrayData() {
        return this.u128ArrayData;
    }

    public void setU128ArrayData(BigInteger[] u128ArrayData) {
        this.u128ArrayData = u128ArrayData;
    }

    private BigInteger[] u256ArrayData;

    public BigInteger[] getU256ArrayData() {
        return this.u256ArrayData;
    }

    public void setU256ArrayData(BigInteger[] u256ArrayData) {
        this.u256ArrayData = u256ArrayData;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public DaySummaryStateDto[] toDaySummaryStateDtoArray(Iterable<DaySummaryState> states) {
            return toDaySummaryStateDtoList(states).toArray(new DaySummaryStateDto[0]);
        }

        public List<DaySummaryStateDto> toDaySummaryStateDtoList(Iterable<DaySummaryState> states) {
            ArrayList<DaySummaryStateDto> stateDtos = new ArrayList();
            for (DaySummaryState s : states) {
                DaySummaryStateDto dto = toDaySummaryStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public DaySummaryStateDto toDaySummaryStateDto(DaySummaryState state)
        {
            if(state == null) {
                return null;
            }
            DaySummaryStateDto dto = new DaySummaryStateDto();
            if (returnedFieldsContains("Day")) {
                dto.setDay(state.getDay());
            }
            if (returnedFieldsContains("Id_")) {
                dto.setId_(state.getId_());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("Metadata")) {
                dto.setMetadata(state.getMetadata());
            }
            if (returnedFieldsContains("OptionalData")) {
                dto.setOptionalData(state.getOptionalData());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OffChainVersion")) {
                dto.setOffChainVersion(state.getOffChainVersion());
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
            if (returnedFieldsContains("ArrayData")) {
                ArrayList<String> arrayList = new ArrayList();
                if (state.getArrayData() != null) {
                    for (String s : state.getArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setArrayData(arrayList.toArray(new String[0]));
            }
            if (returnedFieldsContains("U16ArrayData")) {
                ArrayList<Integer> arrayList = new ArrayList();
                if (state.getU16ArrayData() != null) {
                    for (Integer s : state.getU16ArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setU16ArrayData(arrayList.toArray(new Integer[0]));
            }
            if (returnedFieldsContains("U32ArrayData")) {
                ArrayList<Long> arrayList = new ArrayList();
                if (state.getU32ArrayData() != null) {
                    for (Long s : state.getU32ArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setU32ArrayData(arrayList.toArray(new Long[0]));
            }
            if (returnedFieldsContains("U64ArrayData")) {
                ArrayList<BigInteger> arrayList = new ArrayList();
                if (state.getU64ArrayData() != null) {
                    for (BigInteger s : state.getU64ArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setU64ArrayData(arrayList.toArray(new BigInteger[0]));
            }
            if (returnedFieldsContains("U128ArrayData")) {
                ArrayList<BigInteger> arrayList = new ArrayList();
                if (state.getU128ArrayData() != null) {
                    for (BigInteger s : state.getU128ArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setU128ArrayData(arrayList.toArray(new BigInteger[0]));
            }
            if (returnedFieldsContains("U256ArrayData")) {
                ArrayList<BigInteger> arrayList = new ArrayList();
                if (state.getU256ArrayData() != null) {
                    for (BigInteger s : state.getU256ArrayData()) {
                        arrayList.add(s);
                    }
                }
                dto.setU256ArrayData(arrayList.toArray(new BigInteger[0]));
            }
            return dto;
        }

    }
}
