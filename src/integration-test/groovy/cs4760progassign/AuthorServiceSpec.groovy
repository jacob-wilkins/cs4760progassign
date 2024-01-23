package cs4760progassign

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorServiceSpec extends Specification {

    AuthorService authorService
    SessionFactory sessionFactory

    private Long setupData() {
	Book.executeUpdate("delete from Book")
	Author.executeUpdate("delete from Author")

        Author author = new Author(name: "Test Author").save(flush: true, failOnError: true)
        author.id
    }

    void "test get"() {
	Long author_id = setupData()

        expect:
        authorService.get(author_id) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Author> authorList = authorService.list(max: 2, offset: 0)

        then:
        authorList.size() == 1
        authorList[0].name == "Test Author"
    }

    void "test count"() {
        setupData()

        expect:
        authorService.count() == 1
    }

    void "test delete"() {
        Long authorId = setupData()

        expect:
        authorService.count() == 1

        when:
        authorService.delete(authorId)
        sessionFactory.currentSession.flush()

        then:
        authorService.count() == 0
    }

    void "test save"() {
        when:
        Author author = new Author(name: "Author")
        authorService.save(author)

        then:
        author.id != null
    }
}
