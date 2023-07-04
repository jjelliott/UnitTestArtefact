package unittestartefact

import grails.core.GrailsApplication
import grails.core.GrailsClass
import grails.gorm.transactions.Transactional
import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.hibernate.sql.JoinType

@Transactional
class AuthorService {

    GrailsApplication grailsApplication;

    def listAuthors() {
        List<Author> authorList;
        BuildableCriteria dc = Author.createCriteria();

        authorList = dc.list {
            createAlias 'books', 'b', JoinType.LEFT_OUTER_JOIN
        }

        log.info("AuthorService, serviceMethod, authorList.size: " + authorList.size());
        return authorList;
    }


    def grailsAppTest() {
        GrailsClass grailsClass;
        java.lang.Class domainClass;

        grailsClass = grailsApplication.getArtefact("Domain", 'unittestartefact.Author');
        domainClass = grailsClass?.getClazz();

        return domainClass;
    }
}
