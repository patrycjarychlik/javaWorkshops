package workshop.shopping.list.app.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import swing2swt.layout.BoxLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class MainWindow {

	protected Shell shell;
	private Button btnNewButton;
	private Button btnRemoveButton;
	private Button btnEditButton;
	private Table table;
	private Text textSummary;
	private TableColumn tblclmnNewColumn;
	private TableColumn tblclmnIlo;
	private TableColumn tblclmnCena;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(507, 512);
		shell.setText("ShoppingList");
		shell.setLayout(new FormLayout());
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(100, -10);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 25);
		composite.setLayoutData(fd_composite);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		GridData gd_btnNewButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 130;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Dodaj");
		
		btnRemoveButton = new Button(composite, SWT.NONE);
		GridData gd_btnRemoveButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnRemoveButton.widthHint = 130;
		btnRemoveButton.setLayoutData(gd_btnRemoveButton);
		btnRemoveButton.setText("Usuń");
		
		btnEditButton = new Button(composite, SWT.NONE);
		btnEditButton.setEnabled(false);
		GridData gd_btnEditButton = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnEditButton.widthHint = 130;
		btnEditButton.setLayoutData(gd_btnEditButton);
		btnEditButton.setText("Edytuj");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1);
		gd_table.widthHint = 389;
		gd_table.heightHint = 316;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(176);
		tblclmnNewColumn.setText("Nazwa artykułu");
		
		tblclmnIlo = new TableColumn(table, SWT.NONE);
		tblclmnIlo.setWidth(100);
		tblclmnIlo.setText("Ilość");
		
		tblclmnCena = new TableColumn(table, SWT.NONE);
		tblclmnCena.setWidth(159);
		tblclmnCena.setText("Cena");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Label lbSummary = new Label(composite, SWT.NONE);
		lbSummary.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lbSummary.setText("Suma:");
		
		textSummary = new Text(composite, SWT.BORDER);
		textSummary.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		textSummary.setEditable(false);
		textSummary.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

	}
}
