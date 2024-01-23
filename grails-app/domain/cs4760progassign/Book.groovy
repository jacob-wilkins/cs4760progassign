// Book.groovy
package cs4760progassign

class Book {
    String title
    Integer publishYear

    static belongsTo = [author: Author]

    String toString(){
        "${title}"
    }
}
