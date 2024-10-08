package gui;

import reactor.Reactor;
import reactor.ReactorHolder;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Tree extends Component {

    public Tree() {

    }

    public DefaultMutableTreeNode createTree(ReactorHolder reactorHolder) {

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Реакторы");
        System.out.println(reactorHolder.getReactorHashMap());

        for (Map.Entry<String, Reactor> entry : reactorHolder.getReactorHashMap().entrySet()) {
            DefaultMutableTreeNode reactorNode = new DefaultMutableTreeNode(entry.getKey());
            Reactor reactor = entry.getValue();
            System.out.println(entry.getValue());

            DefaultMutableTreeNode infoNode = new DefaultMutableTreeNode(reactor.toString());
            reactorNode.add(infoNode);

            root.add(reactorNode);
        }
        return root;
    }
}