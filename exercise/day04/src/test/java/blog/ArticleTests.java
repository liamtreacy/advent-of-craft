package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {
    private Article article;

    @BeforeEach
    void setup(){
        article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
    }
    @Test
    void it_should_add_valid_comment() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar");
    }

    @Test
    void it_should_add_a_comment_with_the_given_text() throws CommentAlreadyExistException {
        var text = "Amazing article !!!";
        article.addComment(text, "Pablo Escobar");

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.text().equals(text));
    }

    @Test
    void it_should_add_a_comment_with_the_given_author() throws CommentAlreadyExistException {
        var author = "Pablo Escobar";
        article.addComment("Amazing article !!!", author);

        assertThat(article.getComments())
                .hasSize(1)
                .anyMatch(comment -> comment.author().equals(author));
    }

    @Test
    void it_should_add_a_comment_with_the_date_of_the_day() throws CommentAlreadyExistException {
        article.addComment("Amazing article !!!", "Pablo Escobar");
    }

    @Test
    void it_should_throw_an_exception_when_adding_existing_comment() throws CommentAlreadyExistException {

        article.addComment("Amazing article !!!", "Pablo Escobar");

        assertThatThrownBy(() -> {
            article.addComment("Amazing article !!!", "Pablo Escobar");
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}
