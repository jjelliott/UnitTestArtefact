package unittestartefact

class Book {

    String title

    static hasMany = [pages: Page]

    static constraints = {
    }

}
