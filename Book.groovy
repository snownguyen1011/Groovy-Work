class Book1 {
    private String title
    Book1 (String theTitle) {
        title = theTitle
    }
    String getTitle(){
        return title
} }

Book1  gina = new Book1('Groovy in Action')
assert gina.getTitle()         == 'Groovy in Action'
assert getTitleBackwards(gina) == 'noitcA ni yvoorG'
String getTitleBackwards(Book1) {
    String title = Book1.getTitle()
    return title.reverse()
}