// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.article;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.domain.Command;
import org.test.roochtestproj1.specialization.DomainError;

public interface ReferenceCommand extends Command {

    BigInteger getReferenceNumber();

    void setReferenceNumber(BigInteger referenceNumber);

}

