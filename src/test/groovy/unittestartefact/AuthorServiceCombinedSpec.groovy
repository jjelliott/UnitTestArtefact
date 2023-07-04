package unittestartefact

import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest

class AuthorServiceCombinedSpec extends HibernateSpec implements ServiceUnitTest<AuthorService> {

    @Override
    List<Class> getDomainClasses() {
        [
                Author, Book, Page
        ]
    }

    def setup() {
        Page page1 = new Page(pageNumber: 1, pageText: "Text01");
        Page page2 = new Page(pageNumber: 2, pageText: "Text02");
        Book book1 = new Book(title: "Book1 title");
        book1.addToPages(page1);
        book1.addToPages(page2);
        Author author1 = new Author(name: "Author1");
        author1.addToBooks(book1);
        author1.save();
    }

    def cleanup() {
    }

    def grailsApp() {
        java.lang.Class javaClass;
        List<Author> authorList;

        authorList = service.listAuthors();
        javaClass = service.grailsAppTest();
        println("javaClass?.name: " + javaClass?.name);

        expect:
        authorList?.size() > 0;
        javaClass?.name?.trim()?.length() > 0;
    }

}
