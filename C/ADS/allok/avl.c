// Author - Abdul Aleem
// Date - 11th August 2016
// C program for AVL Tree Implementation

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define LIMIT 10
 
// Structure for AVL Tree Node
struct node
{
    int data;
    int height;
    struct node *left;
    struct node *right;
};

// Function to create a new leaf node for AVL
struct node* create_leaf_node(int data)
{
    struct node* node = (struct node*)malloc(sizeof(struct node));
    node->data = data;
    node->height = 1;  // new node is initially added at leaf
    node->left = NULL;
    node->right = NULL;
    return(node);
}

// Function to return the height of the AVL Tree
int compute_height(struct node* tree)
{
    if (tree==NULL)
        return 0;
    else
        return tree->height;
}

// Function to return the maximum of two integers
int max (int num1, int num2)
{
    return (num1 > num2 ? num1 : num2);
}

// Function to return the balance factor of a given node
int get_balance_factor(struct node *tree)
{
    int bal;
    if (tree == NULL)
        bal = 0;
    else
        bal = compute_height(tree->left) - compute_height(tree->right);
    return bal;
}

// Function to perform right rotation on subtree rooted with given node
struct node *right_rotate(struct node *tree)
{
    struct node *left_child = tree->left;
    struct node *left_right_child = left_child->right;
 
    // Perform rotation
    left_child->right = tree;
    tree->left = left_right_child;
 
    // Update heights
    tree->height = max(compute_height(tree->left), compute_height(tree->right)) + 1;
    left_child->height = max(compute_height(left_child->left), compute_height(left_child->right)) + 1;
 
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
 
    //  Update heights
    tree->height = max(compute_height(tree->left), compute_height(tree->right)) + 1;
    right_child->height = max(compute_height(right_child->left), compute_height(right_child->right)) + 1;
 
    // Return new root
    return right_child;
}

// Function to insert a new node in AVL Tree
struct node* insert_node(struct node *tree, int num)
{
    int balance_factor;
    if (tree == NULL)
        return(create_leaf_node(num));
 
    if (tree->data > num)
        tree->left  = insert_node(tree->left, num);
    else
        tree->right = insert_node(tree->right, num);
 
    // Update height
    tree->height = max(compute_height(tree->left), compute_height(tree->right)) + 1;
 
    // Check AVL tree is balanced or not
    balance_factor = get_balance_factor(tree);
 
    // If unbalanced, then 4 cases of rotation
    // 1. Left Left Case - Only 1 Right Rotate will solve unbalancy
    if (balance_factor > 1 && num < tree->left->data)
        return right_rotate(tree);
 
    // 2. Right Right Case - Only 1 Left Rotate will solve unbalancy
    if (balance_factor < -1 && num >= tree->right->data)
        return left_rotate(tree);
 
    // 3. Left Right Case - Left rotation on left child will make it left left case
    if (balance_factor > 1 && num >= tree->left->data)
    {
        tree->left =  left_rotate(tree->left);
        return right_rotate(tree);
    }
 
    // 4. Right Left Case - Right rotation on right child will make it right right case
    if (balance_factor < -1 && num < tree->right->data)
    {
        tree->right = right_rotate(tree->right);
        return left_rotate(tree);
    }

    // If balanced then return unchanged node 
    return tree;
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


//Function to return the node with minimum data value required for inorder successor/predecessor
struct node * minValueNode(struct node* node)
{
    struct node* current = node;
     // loop down to find the leftmost leaf
    while (current->left != NULL)
        current = current->left;
     return current;
}

// Function to delete a node from the Binary Search Tree and return the new root
struct node* delete_node(struct node *tree, int num)
{
    int balance_factor;
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
        if( (tree->left == NULL) || (tree->right == NULL) )
        {
            if (tree->left != NULL)
                temp = tree->left;
            else
                temp = tree->right;
 
            // No child case
            if(temp == NULL)
            {
                temp = tree;
                tree = NULL;
            }
            else // One child case
                *tree = *temp; // Copy the contents of the non-empty child
            free(temp);
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


    // If the tree had only one node which is now deleted then return
    if (tree == NULL)
      return tree;
    
    // Compute new height after deletion
    tree->height = max(compute_height(tree->left), compute_height(tree->right)) + 1;
 
    // Compute new balance factor after deletion
     balance_factor = get_balance_factor(tree);
 
    // If unbalanced, then 4 cases of rotation
    // 1. Left Left Case - Only 1 Right Rotate will solve unbalancy
    if (balance_factor > 1 && get_balance_factor(tree->left) >= 0)
        return right_rotate(tree);
 
    // 2. Right Right Case - Only 1 Left Rotate will solve unbalancy
    if (balance_factor < -1 && get_balance_factor(tree->right) <= 0)
        return left_rotate(tree);
 
    // 3. Left Right Case - Left rotation on left child will make it left left case
    if (balance_factor > 1 && get_balance_factor(tree->left) < 0)
    {
        tree->left =  left_rotate(tree->left);
        return right_rotate(tree);
    }
 
    // 4. Right Left Case - Right rotation on right child will make it right right case
    if (balance_factor < -1 && get_balance_factor(tree->right) > 0)
    {
        tree->right = right_rotate(tree->right);
        return left_rotate(tree);
    }

    // If balanced then return unchanged node 
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
        printf("\n This program implements a AVL Tree \n");
        printf("\n 1. Insert an element");
        printf("\n 2. Delete an element");
        printf("\n 3. Search an element");
        printf("\n 4. Perform Inorder Traversal");
        printf("\n 5. Perform Preorder Traversal");
        printf("\n 6. Perform Postorder Traversal");
        printf("\n 7. Display AVL Tree (Level Order)");
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

                root = insert_node(root, num);
                printf("\n Element Inserted");
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
                
                flag = binary_search(root, num);
                if (flag == 1)
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
