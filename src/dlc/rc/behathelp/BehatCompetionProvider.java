package dlc.rc.behathelp;

import java.util.Locale;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.editor.completion.CompletionProvider;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionResultSet;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.AsyncCompletionQuery;
import org.netbeans.spi.editor.completion.support.AsyncCompletionTask;

/**
 *
 * @author raymond cascella
 */
@MimeRegistration(mimeType = "text/html", service = CompletionProvider.class)
public class BehatCompetionProvider implements CompletionProvider {

  public BehatCompetionProvider() {

  }

  @Override
  public CompletionTask createTask(int i, JTextComponent jtc) {
    if (i != CompletionProvider.COMPLETION_QUERY_TYPE) {
      return null;
    }
    return new AsyncCompletionTask(new AsyncCompletionQuery() {
      @Override
      protected void query(CompletionResultSet crs, Document dcmnt, int caretOffset) {

        //Iterate through the available steps
        //and assign each country display name
        //to a CompletionResultSet:

        // How do load the files to grep through them???
        String[] things = {"Given", "When", "Them"};
        for (String thing : things) {
          crs.addItem(new BehatCompletionItem(thing, caretOffset));
        }

        crs.finish();
      }
    });
  }

  @Override
  public int getAutoQueryTypes(JTextComponent jtc, String string) {
    return 0;
  }
}
