package com.tamborodemo.questionone;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Vector;

public class HsvTest {

	public static void main(String[] args) {

		int h = 0;
		int s = 0;
		int v = 0;

		Vector<HSVModel> hsvVector = new Vector<HSVModel>();
		LinkedHashSet<HSVModel> complimentorySet = new LinkedHashSet<HSVModel>();

		for (int i = 1; i <= 6; i++) {
			Scanner r = new Scanner(System.in);
			System.out.println("Enter hue...");
			h = r.nextInt();

			System.out.println("Enter saturation...");
			s = r.nextInt();

			System.out.println("Enter hue value...");
			v = r.nextInt();

			HSVModel hsvModel = new HSVModel();

			hsvModel.setHue(h);
			hsvModel.setSaturtion(s);
			hsvModel.setValue(v);

			hsvVector.addElement(hsvModel);
		}

		for (int i = 0; i < hsvVector.size(); i++) {
			for (int j = i + 1; j < hsvVector.size(); j++) {
				HSVModel model1 = hsvVector.get(i);
				HSVModel model2 = hsvVector.get(j);
				if (model1.getHue() > model2.getHue()) {
					if ((model1.getHue() - 180 == model2.getHue())
							&& (model1.getSaturtion() == model2.getSaturtion())
							&& (model1.getValue() == model2.getValue())) {
						complimentorySet.add(hsvVector.get(i));
						complimentorySet.add(hsvVector.get(j));
					}
				} else {
					if ((model1.getHue() + 180 == model2.getHue())
							&& (model1.getSaturtion() == model2.getSaturtion())
							&& (model1.getValue() == model2.getValue())) {
						complimentorySet.add(hsvVector.get(i));
						complimentorySet.add(hsvVector.get(j));
					}
				}
			}
		}

		ArrayList<HSVModel> list = new ArrayList<HSVModel>();
		list.addAll(complimentorySet);
	}
}