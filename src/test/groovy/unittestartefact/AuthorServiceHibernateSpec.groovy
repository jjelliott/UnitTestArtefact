package unittestartefact

import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest

class AuthorServiceHibernateSpec extends HibernateSpec implements ServiceUnitTest<AuthorService> {

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

    def listingTest() {
        List<Author> authorList = service.listAuthors();
        println("authorList size: " + authorList?.size());

        expect:
        authorList?.size() > 0;
    }

}
