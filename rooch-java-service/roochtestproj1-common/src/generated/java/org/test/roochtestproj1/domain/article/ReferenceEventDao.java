// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.article;

import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.domain.*;

public interface ReferenceEventDao {
    void save(ReferenceEvent e);

    Iterable<ReferenceEvent> findByArticleEventId(ArticleEventId articleEventId);

}
