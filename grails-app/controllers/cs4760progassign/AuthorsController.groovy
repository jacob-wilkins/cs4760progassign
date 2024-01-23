package cs4760progassign

class AuthorsController {
    static final boolean debugIndex = true

    def index() { 
        def authors = Author.listOrderByName()
        def bks = Book.listOrderByTitle()
        println ""
        println authors

        def authorList = authors.collect { author ->
            def authorMap = [:]
            authorMap['name'] = author.name
            authorMap['books'] = bks.findAll { it.authorId == author.id }.collect { it.title }
            authorMap
        }

        if (debugIndex) {
            println ""
            println authorList
        }

        render view: "index", model: [authorList: authorList]
    }
}

