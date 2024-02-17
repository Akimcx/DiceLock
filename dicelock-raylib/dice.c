#include "raylib.h"
#include <stdlib.h>
int main(void)
{
    InitWindow(800,600,"DiceLock");
    while (!WindowShouldClose()) {
        BeginDrawing();
        ClearBackground(GRAY);
        EndDrawing();
    }
    CloseWindow();
    return EXIT_SUCCESS;
}
