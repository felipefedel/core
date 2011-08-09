package com.inmethod.grid.examples.pages.treegrid;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.apache.wicket.model.Model;

import com.inmethod.grid.IGridColumn;
import com.inmethod.grid.column.PropertyColumn;
import com.inmethod.grid.column.tree.PropertyTreeColumn;
import com.inmethod.grid.examples.pages.BaseExamplePage;
import com.inmethod.grid.examples.tree.TreeModelFactory;
import com.inmethod.grid.treegrid.TreeGrid;

/**
 * Page with simple {@link TreeGrid}.
 * 
 * @author Felipe Fedel Pinto
 */
public class CookieTreeGridPage extends BaseExamplePage
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 */
	public CookieTreeGridPage()
	{
		List<IGridColumn<DefaultTreeModel, DefaultMutableTreeNode>> columns = new ArrayList<IGridColumn<DefaultTreeModel, DefaultMutableTreeNode>>();

		columns.add(new PropertyTreeColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 1"), "userObject.property1"));
		columns.add(new PropertyColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 2"), "userObject.property2"));
		columns.add(new PropertyColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 3"), "userObject.property3"));
		columns.add(new PropertyColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 4"), "userObject.property4"));
		columns.add(new PropertyColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 5"), "userObject.property5"));
		columns.add(new PropertyColumn<DefaultTreeModel, DefaultMutableTreeNode, String>(
			Model.of("Property 6"), "userObject.property6"));

		DefaultTreeModel model = TreeModelFactory.createTreeModel();
		TreeGrid<DefaultTreeModel, DefaultMutableTreeNode> grid = new TreeGrid<DefaultTreeModel, DefaultMutableTreeNode>(
			"grid", model, columns);

		// expand the root node
		grid.getTreeState().expandNode(model.getRoot());
		grid.setCookieName("cookieTreeGridExample");
		add(grid);
	}

}
