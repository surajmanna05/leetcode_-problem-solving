#include <stdlib.h>
#include <string.h>

char board[9][10];
char ***result;
int *colSizes;
int count;
int capacity;

int isValid(int row, int col, int n) {
    // check column above current row
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q')
            return 0;
    }

    // check upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q')
            return 0;
    }

    // check upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
        if (board[i][j] == 'Q')
            return 0;
    }

    return 1;
}

void addSolution(int n) {
    if (count == capacity) {
        capacity *= 2;
        result = realloc(result, capacity * sizeof(char**));
        colSizes = realloc(colSizes, capacity * sizeof(int));
    }

    result[count] = malloc(n * sizeof(char*));
    for (int i = 0; i < n; i++) {
        result[count][i] = malloc((n + 1) * sizeof(char));
        strcpy(result[count][i], board[i]);
    }
    colSizes[count] = n;
    count++;
}

void solve(int row, int n) {
    if (row == n) {
        addSolution(n);
        return;
    }

    for (int col = 0; col < n; col++) {
        if (isValid(row, col, n)) {
            board[row][col] = 'Q';
            solve(row + 1, n);
            board[row][col] = '.';  // backtrack
        }
    }
}

char*** solveNQueens(int n, int* returnSize, int** returnColumnSizes) {
    count = 0;
    capacity = 16;
    result = malloc(capacity * sizeof(char**));
    colSizes = malloc(capacity * sizeof(int));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            board[i][j] = '.';
        board[i][n] = '\0';
    }

    solve(0, n);

    *returnSize = count;
    *returnColumnSizes = colSizes;
    return result;
}