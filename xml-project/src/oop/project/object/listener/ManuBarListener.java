package oop.project.object.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import oop.project.SharedObject;
import oop.project.object.GroupObject;
import oop.project.object.ObjectBase;

public class ManuBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (SharedObject.buttonMode.equals(SharedObject.buttonModeEnum.selectMode)) {
			switch (e.getActionCommand()) {
			case "group": {
				ObjectBase ob =new GroupObject(SharedObject.lines,SharedObject.shapes);
				SharedObject.shapes.add(ob);
//				System.out.println(e.getActionCommand());
				break;
			}
			case "ungroup": {
				ObjectBase unGroupOb = null;
				int selectedCounter=0;
				for (ObjectBase ob : SharedObject.shapes) {
					if (ob.getSelectedStatic()) {
						selectedCounter+=1;
						unGroupOb=ob;
					}
				}
				if (selectedCounter==1) {
					unGroupOb.ungroup();
				}
//				System.out.println(e.getActionCommand());
				break;
			}
			case "change name": {
				for (ObjectBase ob : SharedObject.shapes) {
					if (ob.getSelectedStatic()) {
						String name = JOptionPane.showInputDialog(SharedObject.getDrawPanel(), "enter name", "name", 3);
						ob.setName(name);
						break;
					}
				}
				SharedObject.getDrawPanel().repaint();
//				System.out.println(e.getActionCommand());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
			}
		}

	}

}
