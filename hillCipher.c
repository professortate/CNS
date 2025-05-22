#include <stdio.h>

int main() {
    // Key matrix (encryption)
    int a[3][3] = { 
        {6, 24, 1}, 
        {13, 16, 10}, 
        {20, 17, 15} 
    };

    // Inverse key matrix (decryption)
    int b[3][3] = { 
        {8, 5, 10}, 
        {21, 8, 21}, 
        {21, 12, 8} 
    };

    char msg[20];
    int c[3], d[3];
    int i, j, temp;

    printf("Enter 3-letter uppercase message: ");
    scanf("%s", msg);

    // Convert message to numbers (A=0, B=1, ..., Z=25)
    for (i = 0; i < 3; i++) {
        c[i] = msg[i] - 'A';
    }

    // Encrypt: d = a * c mod 26
    for (i = 0; i < 3; i++) {
        temp = 0;
        for (j = 0; j < 3; j++) {
            temp += a[i][j] * c[j];
        }
        d[i] = temp % 26;
    }

    // Show encrypted text
    printf("Encrypted Text: ");
    for (i = 0; i < 3; i++) {
        printf("%c", d[i] + 'A');
    }

    // Decrypt: c = b * d mod 26
    for (i = 0; i < 3; i++) {
        temp = 0;
        for (j = 0; j < 3; j++) {
            temp += b[i][j] * d[j];
        }
        c[i] = temp % 26;
    }

    // Show decrypted text
    printf("\nDecrypted Text: ");
    for (i = 0; i < 3; i++) {
        printf("%c", c[i] + 'A');
    }

    return 0;
}
