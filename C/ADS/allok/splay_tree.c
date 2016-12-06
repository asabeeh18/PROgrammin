// C program for Splay Tree Implementation

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define LIMIT 10

int g_flag = 0; // Global Flag
 
// Structure for Tree Node
struct node
{
    int data;
    struct node *left;
    struct node *right;
};

// Function to create a new leaf node for Splay Tree
struct node* create_leaf_node(int data)
{
    struct node* node = (struct node*)malloc(sizeof(struct node));
    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return(node);
}

// Function to calculate the height of the binary Tree
int compute_height(struct node* tree)
{
    int lheight, rheight;
    if (tree==NULL)
        return 0;
    else
    {
        // compute the height of each subtree
        lheight = compute_height(tree->left);
        rheight = compute_height(tree->right);
 
        // use the larger one
        if (lheight > rheight)
            return(lheight+1);
        else
            return(rheight+1);
    }
}

// Function to insert a new node in Splay Tree
void insert_node(struct node *tree, int num)
{
    if (tree->data > num)
    {
        if (tree->left == NULL)
            tree->left = create_leaf_node(num);
        else
            insert_node(tree->left, num);
    }
    else
    {
        if (tree->right == NULL)
            tree->right = create_leaf_node(num);
        else
            insert_node(tree->right, num);
    }
    printf("\n Element Inserted");
}

// Function to perform right rotation on subtree rooted with given node
struct node *right_rotate(struct node *tree)
{
    struct node *left_child = tree->left;
    struct node *left_right_child = left_child->right;
 
    // Perform rotation
    left_child->right = tree;
    tree->left = left_right_child;
 
    // Return new root
    return left_child;
}
 
// Function to perform left rotation on subtree rooted with given node
struct node *left_rotate(struct node *tree)
{
    struct node *right_child = tree->right;
    struct node *right_child_left = right_child->left;
 
    // Perform rotation
    right_child->left = tree;
    tree->right = right_child_left;
 
    // Return new root
    return right_child;
}

// Function to search an element in the given tree
int binary_search(struct node *tree, int num)
{
    // base case
    if (tree == NULL)
        return 0;
 
    // Search element in left sub-tree
    if (num < tree->data)
        return binary_search(tree->left, num);
        
    else if (num > tree->data) // Search element in right sub-tree
        return binary_search(tree->right, num);
        
    else //The current node is having the search element
        return 1;
    return 0;
}

/* Function to perform Splay Operation on Splay Tree. In case of searching an element key
   this function brings the key at root if key is present in tree. If key is not present, 
   then it brings the last accessed item at root. The function modifies tree and returns new root*/
struct node *splay(struct node *tree, int key)
{
    // Base cases: root is NULL or key is present at root
    if (tree == NULL)
        return tree;
    if (tree->data == key)
    {
        g_flag = 1;
        return tree;
    }
 
    // Check if Key lies in left subtree
    if (tree->data > key)
    {
        if (tree->left == NULL) // Key is not in tree
            return tree;
 
        if (tree->left->data > key) // Left Left Case
        {
            // Recursively bring the key as root of left-left
            tree->left->left = splay(tree->left->left, key);
 
            // Do first rotation for root, second rotation is done after else
            tree = right_rotate(tree);
        }
        else if (tree->left->data < key) // Left Right Case
        {
            // Recursively bring the key as root of left-right
            tree->left->right = splay(tree->left->right, key);
 
            // Do first rotation for tree->left
            if (tree->left->right != NULL)
                tree->left = left_rotate(tree->left);
        }
 
        // Do second rotation for root
        if (tree->left == NULL)
            return tree;
        else
            return right_rotate(tree);
    }
    else // Key lies in right subtree
    {
        if (tree->right == NULL) // Key is not in tree
            return tree;
 
        if (tree->right->data > key) // Right Left Case
        {
            // Recursively bring the key as root of right-left
            tree->right->left = splay(tree->right->left, key);
 
            // Do first rotation for tree->right
            if (tree->right->left != NULL)
                tree->right = right_rotate(tree->right);
        }
        else if (tree->right->data < key) // Right Right Case
        {
            // Recursively bring the key as root of right-right
            tree->right->right = splay(tree->right->right, key);
            
            // Do first rotation for tree->right
            tree = left_rotate(tree);
        }
 
        // Do second rotation for root
        if (tree->right == NULL)
            return tree;
        else
            return left_rotate(tree);
    }
}
 
//Function to return the node with minimum data value required for inorder successor/predecessor
struct node * minValueNode(struct node* node)
{
    struct node* current = node;
     // loop down to find the leftmost leaf
    while (current->left != NULL)
        current = current->left;
     return current;
}

// Function to delete a node from the Splay Tree and return the new root
struct node* delete_node(struct node *tree, int num)
{
    struct node *temp = NULL;
    
    // base case
    if (tree == NULL)
        return tree;
 
    // Search element to be deleted in left sub-tree
    if (num < tree->data)
        tree->left = delete_node(tree->left, num);
        
    else if (num > tree->data) // Search element to be deleted in right sub-tree
        tree->right = delete_node(tree->right, num);
        
    else //The current node is to be deleted
    {
        // node with only one child or no child
        if (tree->left == NULL)
        {
            temp = tree->right;
            free(tree);
            return temp;
        }
        else if (tree->right == NULL)
        {
            temp = tree->left;
            free(tree);
            return temp;
        }
        else
        {
            // node with two children: Get the inorder successor (smallest in the right subtree)
            temp = minValueNode(tree->right);
 
            // Copy the inorder successor's content to this node
            tree->data = temp->data;
 
            // Delete the inorder successor
            tree->right = delete_node(tree->right, temp->data);
        }
    }
    return tree;
}

// Function for inorder traversal of Binary Tree
void inorder_traversal(struct node* tree)
{
    if(tree == NULL)
        return;
    inorder_traversal(tree->left);
    printf("\t%d", tree->data);
    inorder_traversal(tree->right);
}

// Function for preorder traversal of Binary Tree
void preorder_traversal(struct node* tree)
{
    if(tree == NULL)
        return;
    printf("\t%d", tree->data);
    preorder_traversal(tree->left);
    preorder_traversal(tree->right);
}

// Function for postorder traversal of Binary Tree
void postorder_traversal(struct node* tree)
{
    if(tree == NULL)
        return;
    postorder_traversal(tree->left);
    postorder_traversal(tree->right);
    printf("\t%d", tree->data);
}

// Function to print all nodes at a given level
void print_level(struct node* tree, int level)
{
    if (tree == NULL)
        return;
    if (level == 1)
        printf("\t%d ", tree->data);
    else if (level > 1)
    {
        print_level(tree->left, level-1);
        print_level(tree->right, level-1);
    }
}

/* Function to print level order traversal a tree*/
void level_order_traversal(struct node* tree)
{
    int counter, height;
    
    height = compute_height(tree);
    printf("\n The tree elements at various level are :\n");
    for (counter = 1; counter <= height; counter++)
    {
        print_level(tree, counter);
        printf("\n");
    }
}

int main()
{
    int choice, counter, flag, num;
    char temp[LIMIT];
    struct node *root = NULL;
    system("clear");
    //root->left        = create_leaf_node(2);
    //root->right       = create_leaf_node(31);
    //root->left->left  = create_leaf_node(14);
    //root->left->right = create_leaf_node(5);
    //root->right->left  = create_leaf_node(44);
    //root->right->right = create_leaf_node(15);    
    do
    {
        // Display Menu for Operation on Binary Tree
        printf("\n This program implements a Splay Tree \n");
        printf("\n 1. Insert an element");
        printf("\n 2. Delete an element");
        printf("\n 3. Search/Splay an element");
        printf("\n 4. Perform Inorder Traversal");
        printf("\n 5. Perform Preorder Traversal");
        printf("\n 6. Perform Postorder Traversal");
        printf("\n 7. Display Splay Tree (Level Order)");
        printf("\n 8. Exit");     
        printf("\n Enter your choice(1-8) : ");
        scanf("%s", temp);
        if (strlen(temp) > 1 || atoi(temp) < 1 || atoi(temp) > 8)
        {
            choice = 0;
        }
        else
            choice = atoi(temp);
        memset(temp, 0 , LIMIT);

        switch(choice)
        {
            case 1:
                do
                {
                    flag = 0;
                    printf("\n Enter the integer element to be inserted : ");
                    scanf("%s", temp);
                    for(counter = 0; counter < strlen(temp); counter++)
                    {
                        if (temp[counter] < 48 || temp[counter] > 57)
                        {
                            printf("\n Invalid Data Type Entered .. Please input valid data type ... ");
                            flag = 1;
                            break;
                        }
                    }
                    num = atoi(temp);
                }while(flag == 1);
                
                if (root == NULL)
                {
                    root = create_leaf_node(num);
                }
                else
                    insert_node(root, num);
                break;

            case 2:
                do
                {
                    flag = 0;
                    printf("\n Enter the element to be deleted : ");
                    scanf("%s", temp);
                    for(counter = 0; counter < strlen(temp); counter++)
                    {
                        if (temp[counter] < 48 || temp[counter] > 57)
                        {
                            printf("\n Invalid Data Type Entered .. Please input valid data type ... ");
                            flag = 1;
                            break;
                        }
                    }
                    num = atoi(temp);
                }while(flag == 1);
                
                flag = binary_search(root, num);
                if (flag == 1)
                {
                    root = delete_node(root, num);
                    printf("\n Element Deleted");
                }
                else
                    printf("\n Deletion Element not found");
                break;

            case 3:
                do
                {
                    flag = 0;
                    printf("\n Enter the element to be searched : ");
                    scanf("%s", temp);
                    for(counter = 0; counter < strlen(temp); counter++)
                    {
                        if (temp[counter] < 48 || temp[counter] > 57)
                        {
                            printf("\n Invalid Data Type Entered .. Please input valid data type ... ");
                            flag = 1;
                            break;
                        }
                    }
                    num = atoi(temp);
                }while(flag == 1);

                g_flag = 0;
                root = splay(root, num);
                if (g_flag == 1)
                    printf("\n Element Found");
                else
                    printf("\n Element not found");
                break;
                
            case 4:
                printf("\n The Inorder Traversal of Entered Binary Tree is : \n");
                inorder_traversal(root);
                break;
                
            case 5:
                printf("\n The Preorder Traversal of Entered Binary Tree is : \n");
                preorder_traversal(root);
                break;
                
            case 6:
                printf("\n The Postorder Traversal of Entered Binary Tree is : \n");
                postorder_traversal(root);
                break;
                
            case 7:
                level_order_traversal(root);
                break;
                
            case 8:
                break;
                
            default:
                printf("\nInvalid Choice\n");
        }
    }while(choice != 8);  
    return 0;
}
