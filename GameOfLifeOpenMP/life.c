//SongyanLai CS402 Assignment
//
//50x50 Grid：#define N 50, initialized with rand()%2.
//
//Rules：alive counts neighbors, updates nxt via conditional checks.
//
//OpenMP Parallelism：#pragma omp parallel for collapse(2) parallelizes loops, double buffering (cur/nxt) avoids race conditions.
//
//Consistency：Identical final grids for 1/8 threads (guaranteed by pointer swapping).
//
//Performance：Timed by omp_get_wtime(), switch threads via OMP_NUM_THREADS=1/8.
//
//Output：Initial/final states ('O' alive, '.' dead), thread count and execution time.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>
#define N 1000     // 增大网格到 1000x1000
#define ITER 1000  // 增加迭代到 1000次


// Count the number of surviving neighbours around the cell
static inline int alive(int x, int y, char G[N][N]) {
    int cnt = 0;
    for(int i = x-1; i <= x+1; i++)
        for(int j = y-1; j <= y+1; j++)
            if ((i!=x || j!=y) && i>=0 && i<N && j>=0 && j<N)
                cnt += G[i][j];
    return cnt;
}

// Print current status
void print_grid(char G[N][N]) {
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++)
            putchar(G[i][j] ? 'O' : '.');
        putchar('\n');
    }
    putchar('\n');
}

int main() {
    static char A[N][N], B[N][N];
    char (*cur)[N] = A, (*nxt)[N] = B;
    // Randomly initialise the current grid
    srand(time(NULL));
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
            cur[i][j] = rand() % 2;
    printf("Initial state:\n");
    print_grid(cur);
    double t0 = omp_get_wtime();
    for(int gen=0; gen<ITER; gen++) {
        // Parallel Computing Next-Generation Cells
        #pragma omp parallel for collapse(2)
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++){
                int neighbors = alive(i,j,cur);
                // Applying the rules of the game
                if(cur[i][j])
                    nxt[i][j] = (neighbors == 2 || neighbors == 3);
                else
                    nxt[i][j] = (neighbors == 3);
            }
        // Exchange Current and Next Generation
        char (*tmp)[N] = cur;
        cur = nxt;
        nxt = tmp;
    }
    double t1 = omp_get_wtime();
    printf("Final state after %d generations:\n", ITER);
    print_grid(cur);
    printf("Threads: %d, Time: %.3f s\n",
           omp_get_max_threads(), t1-t0);

    return 0;
}
