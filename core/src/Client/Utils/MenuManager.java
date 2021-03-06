package Client.Utils;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.Viewport;

import Client.Components.UIComponent;

public class MenuManager {

	private Stage stage;
	private Table table;
	private Skin skin;
	
	private LinkedList<TextButton> buttons;
	
	private boolean fillCell;
	
	private float cellWidth;
	private float cellHeight;
	private float padding;
	
	private float menuScale;
	private int fontSize;
	
	public MenuManager(Viewport view, InputMultiplexer in) {
		
		menuScale = 1;
		fontSize = 32;
		
		stage = new Stage(view);
		skin = createBasicSkin();
		in.addProcessor(stage);
		
		buttons = new LinkedList<TextButton>();
		
		fillCell = true;
		
		cellWidth = 2;
		cellHeight = 2;
		
		padding = 5;
		
		table = new Table();
		
		table.setFillParent(true);
		stage.addActor(table);
		
	}
	
	public MenuManager(Viewport view, int fontSize) {
		
		menuScale = 1;
		this.fontSize = fontSize;
		
		stage = new Stage(view);
		Gdx.input.setInputProcessor(stage);
		skin = createBasicSkin();
		
		buttons = new LinkedList<TextButton>();
		
		fillCell = true;
		
		cellWidth = 2;
		cellHeight = 2;
		
		padding = 5;
		
		table = new Table();
		
		table.setFillParent(true);
		stage.addActor(table);
		
	}
	
	public MenuManager(Viewport view) {
		
		menuScale = 1;
		fontSize = 32;
		
		stage = new Stage(view);
		
		Gdx.input.setInputProcessor(stage);
		skin = createBasicSkin();
		
		buttons = new LinkedList<TextButton>();
		
		fillCell = true;
		
		cellWidth = 2;
		cellHeight = 2;
		
		padding = 5;
		
		table = new Table();
		
		table.setFillParent(true);
		stage.addActor(table);
		
	}
	
	public Table addTable(){
		
		Table table = new Table();
		table.setFillParent(true);
		table.setVisible(false);
		
		stage.addActor(table);
		
		return table;
	}
	
	public void render(float delta){
		stage.act();
		stage.draw();
	}
	
	public TextField addTextField(){
		
		TextField field = new TextField("", skin);
		table.add(field).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return field;
		
	}
	
	public TextField addTextField(Table table){
		
		TextField field = new TextField("", skin);
		table.add(field).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return field;
		
	}
	
	public void setFillCell(boolean enable){
		fillCell = enable;
	}
	
	public void setActorCellSize(float width, float height, Actor actor){
		Cell<Actor> cell = table.getCell(actor);
		cell.width(width * menuScale);
		cell.height(height * menuScale);
	}
	
	public void setActorCellSize(Table table, float width, float height, Actor actor){
		Cell<Actor> cell = table.getCell(actor);
		cell.width(width * menuScale);
		cell.height(height * menuScale);
	}
	
	public void setCellSize(float width, float height){
		cellWidth = width * menuScale;
		cellHeight = height * menuScale;
	}
	
	public void setCellPadding(float padding){
		this.padding = padding;
	}
	
	public void dispose(){
		skin.dispose();
		stage.dispose();
	}
	
	public TextArea addTextArea(){
		TextArea area = new TextArea("", skin);
		table.add(area).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return area;
	}
	
	public TextArea addTextArea(Table table){
		TextArea area = new TextArea("", skin);
		table.add(area).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return area;
	}
	
	public TextButton addTextButton(String text){
		
		TextButton button = new TextButton(text, skin);
		
		if(fillCell){
			table.add(button).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		}else{
			table.add(button).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		}
		
		if(buttons.size() == 0){
			button.setColor(Color.DARK_GRAY);
		}
		
		buttons.add(button);
		
		return button;
	}
	
	public TextButton addTextButton(Table table, String text){
		
		TextButton button = new TextButton(text, skin);
		
		if(fillCell){
			table.add(button).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		}else{
			table.add(button).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		}
		
		if(buttons.size() == 0){
			button.setColor(Color.DARK_GRAY);
		}
		
		buttons.add(button);
		
		return button;
	}
	
	public Label addLabel(String text){
		Label label = new Label(text, skin);
		table.add(label).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return label;
	}
	
	public Label addLabel(Table table, String text){
		Label label = new Label(text, skin);
		table.add(label).pad(padding).width(cellWidth * menuScale).height(cellHeight * menuScale);
		return label;
	}
	
	public void row(){
		table.row();
	}
	
	public void setMenuScale(float scale){
		menuScale = scale;
	}
	
	public Table getMainTable(){
		return table;
	}
	
	public Label addFloatingText(String text, float x, float y){
		Label label = new Label(text, skin);
		label.setPosition(x, y);
		stage.addActor(label);
		return label;
	}
	
	public TextField addFloatingTextField(float x, float y, float width, float height){
		
		TextField field = new TextField("", skin);
		field.setPosition(x, y);
		field.setSize(width, height);
		
		stage.addActor(field);
		
		return field;
	}
	
	public UIComponent addStatsUI(float x, float y, float width, float height, float gap){
		
		Pixmap pixmap = new Pixmap((int)(width), (int)(height), Pixmap.Format.RGB888);
		pixmap.setColor(Color.BLACK);
		pixmap.fill();
		
		Texture healthFrameTex = new Texture(new PixmapTextureData(pixmap, pixmap.getFormat(), false, true));
		Sprite healthFrameSprite = new Sprite(healthFrameTex);
		healthFrameSprite.setPosition(x, y);
		healthFrameSprite.setSize(width, height);
		
		
		pixmap = new Pixmap((int)(width), (int)(height), Pixmap.Format.RGB888);
		pixmap.setColor(Color.GREEN);
		pixmap.fill();
		
		Texture healthTex = new Texture(new PixmapTextureData(pixmap, pixmap.getFormat(), false, true));
		Sprite healthSprite = new Sprite(healthTex);
		healthSprite.setPosition(x + height * 0.1f, y + height * .1f);
		healthSprite.setSize(width - (height * .2f), height * .8f);
		
		x += gap + width;
		
		pixmap = new Pixmap((int)(width), (int)(height), Pixmap.Format.RGB888);
		pixmap.setColor(Color.ORANGE);
		pixmap.fill();
		
		Texture energyTex = new Texture(new PixmapTextureData(pixmap, pixmap.getFormat(), false, true));
		Sprite energySprite = new Sprite(energyTex);
		energySprite.setPosition(x + height* .1f, y + height * .1f);
		energySprite.setSize(width - (height * .2f), height * .8f);
		
		pixmap = new Pixmap((int)(width), (int)(height), Pixmap.Format.RGB888);
		pixmap.setColor(Color.BLACK);
		pixmap.fill();
		
		Texture energyFrameTex = new Texture(new PixmapTextureData(pixmap, pixmap.getFormat(), false, true));
		Sprite energyFrameSprite = new Sprite(energyFrameTex);
		energyFrameSprite.setPosition(x, y);
		energyFrameSprite.setSize(width, height);
		
		
		return new UIComponent(healthSprite, energySprite, healthFrameSprite, energyFrameSprite);
	}
	
	public Stage getStage(){
		return stage;
	}

	private Skin createBasicSkin(){
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Constants.FONT_FILE);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = fontSize;
		parameter.magFilter = TextureFilter.Linear;
		BitmapFont bigFont = generator.generateFont(parameter);
		
		parameter.size = fontSize/2;
		BitmapFont font = generator.generateFont(parameter);
		
		generator.dispose();
		
		Skin skin = new Skin();
		skin.add("default", font);
		
		Pixmap pixmap = new Pixmap((int)Constants.V_WIDTH/4, (int)Constants.V_HEIGHT/10, Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background", new Texture(pixmap));
		
		pixmap = new Pixmap(2, 100, Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("cursor", new Texture(pixmap));
		
		TextButton.TextButtonStyle textStyle = new TextButton.TextButtonStyle();
		textStyle.up = skin.newDrawable("background", Color.GRAY);
		textStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
		textStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
		textStyle.font = skin.getFont("default");
		skin.add("default", textStyle);
		
		Label.LabelStyle labelStyle = new LabelStyle(bigFont, Color.BLACK);
		skin.add("default", labelStyle);
		
		TextField.TextFieldStyle fieldStyle = new TextFieldStyle();
		fieldStyle.font = font;
		fieldStyle.fontColor = Color.BLACK;
		fieldStyle.cursor = skin.newDrawable("cursor", Color.BLACK);
		fieldStyle.background = skin.newDrawable("background", Color.LIGHT_GRAY);
		skin.add("default", fieldStyle);
		
		TextArea.TextFieldStyle areaStyle = new TextFieldStyle();
		areaStyle.font = font;
		areaStyle.fontColor = Color.BLACK;
		areaStyle.background = skin.newDrawable("background", Color.LIGHT_GRAY);
		skin.add("default", fieldStyle);
		
		return skin;
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	public void removeActor(Actor actor) {
		actor.remove();
	}

	public TextButton addFloatingButton(String text, int x, int y) {
		
		TextButton button = new TextButton(text, skin);
		buttons.add(button);
		stage.addActor(button);
		
		return button;
	}
	
}