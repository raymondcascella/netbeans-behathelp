package dlc.rc.behathelp;

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
      protected void query(CompletionResultSet crs, Document dcmnt, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    });
  }

  @Override
  public int getAutoQueryTypes(JTextComponent jtc, String string) {
    return 0;
  }
}
