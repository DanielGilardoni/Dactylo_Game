package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import principal.ListeMots;
import principal.DactyloGame;
import principal.Mot;

public class ModeNormalView extends JPanel{
    private DactyloGame dactylo = null;
    private ListeMots list = null;
	private JPanel[] mots;
    private String curString = "";
    private GameView game;
    private int pos = 0;

    public ModeNormalView(ListeMots list, GameView game, DactyloGame dactylo, int pos) {	
        this.dactylo = dactylo;
        this.pos = pos;
        this.list = list;
        this.setBackground(Gui.MINT_COLOR);
        this.mots = createMotsPanel(list);
        this.game = game;
        this.curString = updateColorCurrent();
        JLabel curJLabel = new JLabel(curString);
        curJLabel.setFont(new Font("Verdana", Font.PLAIN, 25));
        JPanel curJPanel = new JPanel();
        curJPanel.setBackground(Gui.BEIGE_COLOR);
        curJPanel.add(curJLabel);
        this.add(curJPanel);

        for (int i = 1; i < this.dactylo.getMax(); i++)
            this.add(mots[i]);
    }

    private JPanel[] createMotsPanel(ListeMots list) {
        JPanel []res = new JPanel[dactylo.getMax()];
	        for (int i = 0; i < dactylo.getMax(); i++) {
            JLabel mot = new JLabel(this.list.getListe().get(i).getMot());
            mot.setForeground(Gui.BLACK_COLOR);
            mot.setFont(new Font("Verdana", Font.PLAIN, 25));
            res[i] = new JPanel();
            res[i].add(mot);
            res[i].setBackground(Gui.BEIGE_COLOR);
        }
        return (res);
    }

    private String updateColorCurrent() {
		Mot first = this.list.getListe().getFirst();
		String current = first.getMot();
        String res = "";
		int length = first.getMot().length();
        System.out.println("pos = " + this.pos + " length = " + length);
		if (this.pos <= length) {
            System.out.println("pos <= length");
			res += "<html>";
			if (this.pos >= 0 && this.pos < length) {
                System.out.println("pos >= 0");
				String tmp = "";
				for(int i = 0; i < this.pos; i++) {
					tmp += current.charAt(i);
				}
				res += tmp;
			}
			if (this.pos != length) {
                System.out.println("pos != length");
				res += "<FONT COLOR=YELLOW>" + current.charAt(this.pos) + "</FONT>";
            }
            if (this.pos == length) {
                System.out.println("pos == length");
                if (this.list.getListe().get(0).compareMots(first) == true) {
                    System.out.println("compareMots == true");
                    res += "<FONT COLOR=GREEN>" + res + "</FONT>";
                }
                else {
                    System.out.println("compareMots == false");
                    res += "<FONT COLOR=RED>" + res + "</FONT>";
                } 
            }
			else if (this.pos < length) {
                System.out.println("pos + 1 < length");
				char [] tmp = new char [length - this.pos - 1];
				for(int i = 0, j = this.pos + 1; j < length; i++, j++)
					tmp[i] = current.charAt(j);
				String temp = "<FONT COLOR=WHITE>" + new String(tmp) + "</FONT>";
				res += temp;
			}
            System.out.println("res = " + res);
			res += "</html>";
            System.out.println("pos = " + pos);
			game.newWord(current, pos);
			return (res);
		}else {
            return (res);
		}

}

//	public String updateColorCurrent()
//	{
//		Mot first = this.list.getFirst();
//		String current = first.getStr();
//		String res = "";
//		int pos = first.getPos();
//		int length = first.getLength();
//
//		if (pos <= length) {
//			res += "<html>";
//			if (pos > 0) {
//				String tmp = "";
//				for(int i = 0; i < pos; i++) {
//					boolean[] bool = first.getGoodkey();
//					if (bool[i] == false)
//						tmp += "<FONT COLOR=RED>" + current.charAt(i) +  "</FONT>";
//					else
//						tmp += "<FONT COLOR=GREEN>" + current.charAt(i) +  "</FONT>";
//				}
//				res += tmp;
//			}
//			if (pos != length)
//				res += "<FONT COLOR=YELLOW>" + current.charAt(pos) + "</FONT>";
//			if (pos + 1 < length) {
//				char [] tmp = new char [length - pos - 1];
//				for(int i = 0, j = pos + 1; j < length; i++, j++)
//					tmp[i] = current.charAt(j);
//				String temp = "<FONT COLOR=WHITE>" + new String(tmp) + "</FONT>";
//				res += temp;
//			}
//			res += "</html>";
//			game.setoldString(res);
//			return (res);
//		}else {
//			return (game.getoldString());
//		}
//	}

    public JPanel getPanel() {
		return this;
	}

}