package ui.Frames;

import java.awt.Dimension;

import ui.Handler;

@SuppressWarnings("serial")
public class EmptyPanel extends CustomPanel {

	public EmptyPanel(Handler handler) {
		super(handler);
	}

	@Override
	protected void altaButtonAction() {}

	@Override
	protected void setPanel() {
		start("");
	}

	@Override
	protected void initUI() {
	}

	@Override
	protected void setDimension() {
		size = new Dimension(120, 15);
	}
}
