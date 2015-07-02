package campbell.language.model;

/**
 * Interface for nodes in the Abstract Syntax Tree
 */
public interface Node {
    int getCol();
    int getLine();
    public void checkType();
}
