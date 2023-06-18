// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.roochtestproj1.domain.article;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.roochtestproj1.domain.*;
import org.test.roochtestproj1.specialization.*;

public abstract class AbstractArticleAggregate extends AbstractAggregate implements ArticleAggregate {
    private ArticleState.MutableArticleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractArticleAggregate(ArticleState state) {
        this.state = (ArticleState.MutableArticleState)state;
    }

    public ArticleState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        ArticleCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimpleArticleAggregate extends AbstractArticleAggregate {
        public SimpleArticleAggregate(ArticleState state) {
            super(state);
        }

        @Override
        public void create(String title, String author, String content, ReferenceVO[] references, String[] tags, Long offChainVersion, String commandId, String requesterId, ArticleCommands.Create c) {
            try {
                verifyCreate(title, author, content, references, tags, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            Event e = newArticleCreated(title, author, content, references, tags, offChainVersion, commandId, requesterId);
            apply(e);
        }

        @Override
        public void addReference(BigInteger referenceNumber, String title, String url, Long offChainVersion, String commandId, String requesterId, ArticleCommands.AddReference c) {
            try {
                verifyAddReference(referenceNumber, title, url, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            Event e = newReferenceAdded(referenceNumber, title, url, offChainVersion, commandId, requesterId);
            apply(e);
        }

        @Override
        public void updateReference(BigInteger referenceNumber, String title, String url, String author, Long offChainVersion, String commandId, String requesterId, ArticleCommands.UpdateReference c) {
            try {
                verifyUpdateReference(referenceNumber, title, url, author, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            Event e = newReferenceUpdated(referenceNumber, title, url, author, offChainVersion, commandId, requesterId);
            apply(e);
        }

        @Override
        public void removeReference(BigInteger referenceNumber, Long offChainVersion, String commandId, String requesterId, ArticleCommands.RemoveReference c) {
            try {
                verifyRemoveReference(referenceNumber, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            Event e = newReferenceRemoved(referenceNumber, offChainVersion, commandId, requesterId);
            apply(e);
        }

        protected void verifyCreate(String title, String author, String content, ReferenceVO[] references, String[] tags, ArticleCommands.Create c) {
            String Title = title;
            String Author = author;
            String Content = content;
            ReferenceVO[] References = references;
            String[] Tags = tags;

            ReflectUtils.invokeStaticMethod(
                    "org.test.roochtestproj1.domain.article.CreateLogic",
                    "verify",
                    new Class[]{ArticleState.class, String.class, String.class, String.class, ReferenceVO[].class, String[].class, VerificationContext.class},
                    new Object[]{getState(), title, author, content, references, tags, VerificationContext.forCommand(c)}
            );

//package org.test.roochtestproj1.domain.article;
//
//public class CreateLogic {
//    public static void verify(ArticleState articleState, String title, String author, String content, ReferenceVO[] references, String[] tags, VerificationContext verificationContext) {
//    }
//}

        }
           

        protected void verifyAddReference(BigInteger referenceNumber, String title, String url, ArticleCommands.AddReference c) {
            BigInteger ReferenceNumber = referenceNumber;
            String Title = title;
            String Url = url;

            ReflectUtils.invokeStaticMethod(
                    "org.test.roochtestproj1.domain.article.AddReferenceLogic",
                    "verify",
                    new Class[]{ArticleState.class, BigInteger.class, String.class, String.class, VerificationContext.class},
                    new Object[]{getState(), referenceNumber, title, url, VerificationContext.forCommand(c)}
            );

//package org.test.roochtestproj1.domain.article;
//
//public class AddReferenceLogic {
//    public static void verify(ArticleState articleState, BigInteger referenceNumber, String title, String url, VerificationContext verificationContext) {
//    }
//}

        }
           

        protected void verifyUpdateReference(BigInteger referenceNumber, String title, String url, String author, ArticleCommands.UpdateReference c) {
            BigInteger ReferenceNumber = referenceNumber;
            String Title = title;
            String Url = url;
            String Author = author;

            ReflectUtils.invokeStaticMethod(
                    "org.test.roochtestproj1.domain.article.UpdateReferenceLogic",
                    "verify",
                    new Class[]{ArticleState.class, BigInteger.class, String.class, String.class, String.class, VerificationContext.class},
                    new Object[]{getState(), referenceNumber, title, url, author, VerificationContext.forCommand(c)}
            );

//package org.test.roochtestproj1.domain.article;
//
//public class UpdateReferenceLogic {
//    public static void verify(ArticleState articleState, BigInteger referenceNumber, String title, String url, String author, VerificationContext verificationContext) {
//    }
//}

        }
           

        protected void verifyRemoveReference(BigInteger referenceNumber, ArticleCommands.RemoveReference c) {
            BigInteger ReferenceNumber = referenceNumber;

            ReflectUtils.invokeStaticMethod(
                    "org.test.roochtestproj1.domain.article.RemoveReferenceLogic",
                    "verify",
                    new Class[]{ArticleState.class, BigInteger.class, VerificationContext.class},
                    new Object[]{getState(), referenceNumber, VerificationContext.forCommand(c)}
            );

//package org.test.roochtestproj1.domain.article;
//
//public class RemoveReferenceLogic {
//    public static void verify(ArticleState articleState, BigInteger referenceNumber, VerificationContext verificationContext) {
//    }
//}

        }
           

        protected AbstractArticleEvent.ArticleCreated newArticleCreated(String title, String author, String content, ReferenceVO[] references, String[] tags, Long offChainVersion, String commandId, String requesterId) {
            ArticleEventId eventId = new ArticleEventId(getState().getId(), null);
            AbstractArticleEvent.ArticleCreated e = new AbstractArticleEvent.ArticleCreated();

            e.setTitle(title);
            e.setAuthor(author);
            e.setContent(content);
            e.setReferences(references);
            e.setTags(tags);
            e.setOwner(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochEventId(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochSender(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTxHash(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTypeTag(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTimestampMs(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochBlockHeight(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochEventIndex(null); // todo Need to update 'verify' method to return event properties.
            e.setStatus(null); // todo Need to update 'verify' method to return event properties.

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setArticleEventId(eventId);
            return e;
        }

        protected AbstractArticleEvent.ReferenceAdded newReferenceAdded(BigInteger referenceNumber, String title, String url, Long offChainVersion, String commandId, String requesterId) {
            ArticleEventId eventId = new ArticleEventId(getState().getId(), null);
            AbstractArticleEvent.ReferenceAdded e = new AbstractArticleEvent.ReferenceAdded();

            e.setReferenceNumber(referenceNumber);
            e.setTitle(title);
            e.setUrl(url);
            e.setRoochEventId(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochSender(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTxHash(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTypeTag(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTimestampMs(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochBlockHeight(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochEventIndex(null); // todo Need to update 'verify' method to return event properties.
            e.setStatus(null); // todo Need to update 'verify' method to return event properties.

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setArticleEventId(eventId);
            return e;
        }

        protected AbstractArticleEvent.ReferenceUpdated newReferenceUpdated(BigInteger referenceNumber, String title, String url, String author, Long offChainVersion, String commandId, String requesterId) {
            ArticleEventId eventId = new ArticleEventId(getState().getId(), null);
            AbstractArticleEvent.ReferenceUpdated e = new AbstractArticleEvent.ReferenceUpdated();

            e.setReferenceNumber(referenceNumber);
            e.setTitle(title);
            e.setUrl(url);
            e.setAuthor(author);
            e.setRoochEventId(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochSender(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTxHash(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTypeTag(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTimestampMs(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochBlockHeight(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochEventIndex(null); // todo Need to update 'verify' method to return event properties.
            e.setStatus(null); // todo Need to update 'verify' method to return event properties.

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setArticleEventId(eventId);
            return e;
        }

        protected AbstractArticleEvent.ReferenceRemoved newReferenceRemoved(BigInteger referenceNumber, Long offChainVersion, String commandId, String requesterId) {
            ArticleEventId eventId = new ArticleEventId(getState().getId(), null);
            AbstractArticleEvent.ReferenceRemoved e = new AbstractArticleEvent.ReferenceRemoved();

            e.setReferenceNumber(referenceNumber);
            e.setRoochEventId(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochSender(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTxHash(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTypeTag(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochTimestampMs(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochBlockHeight(null); // todo Need to update 'verify' method to return event properties.
            e.setRoochEventIndex(null); // todo Need to update 'verify' method to return event properties.
            e.setStatus(null); // todo Need to update 'verify' method to return event properties.

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setArticleEventId(eventId);
            return e;
        }

    }

}

