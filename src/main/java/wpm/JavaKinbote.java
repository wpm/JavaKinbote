package wpm;

import com.github.wpm.kinbote.Annotator;
import com.github.wpm.kinbote.AnnotatorChain;
import com.github.wpm.kinbote.DocumentAnalysis;

import java.util.Arrays;
import java.util.List;

import static com.github.wpm.kinbote.examples.SimpleRegularExpression.SentenceSplitter;
import static com.github.wpm.kinbote.examples.SimpleRegularExpression.WhitespaceTokenizer;

public class JavaKinbote {
    public static void main(String[] args) {
        String document = "Pat saw Kim. She nodded.";
        List<Annotator> annotators = Arrays.asList(new WhitespaceTokenizer(), new SentenceSplitter());
        AnnotatorChain annotator = new AnnotatorChain(scala.collection.JavaConversions.asScalaBuffer(annotators));
        DocumentAnalysis analysis = annotator.apply(document,
                new DocumentAnalysis(DocumentAnalysis.apply$default$1(), DocumentAnalysis.apply$default$2()));
        System.out.println(analysis.toDot());
        System.out.println(analysis.toJson().prettyPrint());
    }
}
