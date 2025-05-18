#include <stdio.h>
#include <ctype.h>

int main() {
    char str[] = "Hello World";  // Input string
    int i;

    printf("Original String: %s\n\n", str);

    printf("Character | ASCII | OR with 127 | XOR with 127 | AND with 127\n");
    printf("---------------------------------------------------------------\n");

    for (i = 0; str[i] != '\0'; i++) {
        char original = str[i];
        int ascii_value = (int)original;
        char or_result = original | 127;
        char xor_result = original ^ 127;
        char and_result = original & 127;

        printf("   %3c    |  %3d  |    %3d (%c)    |    %3d (%c)    |    %3d (%c)\n",
               original, ascii_value,
               or_result, isprint(or_result) ? or_result : ' ',
               xor_result, isprint(xor_result) ? xor_result : ' ',
               and_result, isprint(and_result) ? and_result : ' ');
    }

    return 0;
}
