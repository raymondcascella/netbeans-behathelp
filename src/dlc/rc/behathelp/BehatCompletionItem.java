/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlc.rc.behathelp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.text.JTextComponent;
import org.netbeans.spi.editor.completion.CompletionItem;
import org.netbeans.spi.editor.completion.CompletionTask;
import org.netbeans.spi.editor.completion.support.CompletionUtilities;
import org.openide.util.ImageUtilities;

/**
 *
 * @author raymond
 */
public class BehatCompletionItem implements CompletionItem {

  private String text;
  private static ImageIcon fieldIcon = new ImageIcon();
  private static Color fieldColor = Color.decode("0x0000B2");
  private int caretOffset;

  public BehatCompletionItem(String text, int caretOffset) {
    this.text = text;
    this.caretOffset = caretOffset;
  }

  @Override
  public void defaultAction(JTextComponent jtc) {
  }

  @Override
  public void processKeyEvent(KeyEvent ke) {
  }

  @Override
  public int getPreferredWidth(Graphics graphics, Font font) {
    return CompletionUtilities.getPreferredWidth(text, null, graphics, font);
  }

  @Override
  public void render(Graphics graphics, Font font, Color defaultColor, Color backgroundColor, int width, int height, boolean selected) {
    CompletionUtilities.renderHtml(fieldIcon, text, null, graphics, font, (selected ? Color.white : fieldColor), width, height, selected);
  }

  @Override
  public CompletionTask createDocumentationTask() {
    return null;
  }

  @Override
  public CompletionTask createToolTipTask() {
    return null;
  }

  @Override
  public boolean instantSubstitution(JTextComponent jtc) {
    return false;
  }

  @Override
  public int getSortPriority() {
    return 0;
  }

  @Override
  public CharSequence getSortText() {
    return text;
  }

  @Override
  public CharSequence getInsertPrefix() {
    return text;
  }

}
