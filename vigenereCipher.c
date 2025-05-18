#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_TEXT_LENGTH 1000
#define MAX_KEY_LENGTH 100

char vigenereTable[26][26];

void generateVigenereTable() {
    for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
            vigenereTable[i][j] = 'A' + (i + j) % 26;
        }
    }
}

void displayVigenereTable() {
    printf("Vigenère Table:\n   ");
    for (char c = 'A'; c <= 'Z'; c++) {
        printf(" %c", c);
    }
    printf("\n");

    for (int i = 0; i < 26; i++) {
        printf("%c: ", 'A' + i);
        for (int j = 0; j < 26; j++) {
            printf(" %c", vigenereTable[i][j]);
        }
        printf("\n");
    }
}

void toUpperCase(char *str) {
    for (int i = 0; str[i]; i++) {
        str[i] = toupper(str[i]);
    }
}

void encryptVigenere(char *plaintext, char *key) {
    int plaintextLength = strlen(plaintext);
    int keyLength = strlen(key);
    int keyIndex = 0;

    toUpperCase(key);  // Ensure key is in uppercase

    for (int i = 0; i < plaintextLength; i++) {
        if (isalpha(plaintext[i])) {
            char upperChar = toupper(plaintext[i]);
            int row = key[keyIndex] - 'A';
            int col = upperChar - 'A';
            plaintext[i] = vigenereTable[row][col];
            keyIndex = (keyIndex + 1) % keyLength;
        }
    }
}

void decryptVigenere(char *ciphertext, char *key) {
    int ciphertextLength = strlen(ciphertext);
    int keyLength = strlen(key);
    int keyIndex = 0;

    toUpperCase(key);  // Ensure key is in uppercase

    for (int i = 0; i < ciphertextLength; i++) {
        if (isalpha(ciphertext[i])) {
            char upperChar = toupper(ciphertext[i]);
            int row = key[keyIndex] - 'A';
            for (int j = 0; j < 26; j++) {
                if (vigenereTable[row][j] == upperChar) {
                    ciphertext[i] = 'A' + j;
                    break;
                }
            }
            keyIndex = (keyIndex + 1) % keyLength;
        }
    }
}

int main() {
    generateVigenereTable();
    displayVigenereTable();  // Display the table before asking for input

    char plaintext[MAX_TEXT_LENGTH];
    char key[MAX_KEY_LENGTH];

    printf("\nEnter plaintext: ");
    fgets(plaintext, sizeof(plaintext), stdin);
    plaintext[strcspn(plaintext, "\n")] = '\0'; // Remove newline

    printf("Enter key: ");
    fgets(key, sizeof(key), stdin);
    key[strcspn(key, "\n")] = '\0'; // Remove newline

    encryptVigenere(plaintext, key);
    printf("Encrypted text: %s\n", plaintext);

    decryptVigenere(plaintext, key);
    printf("Decrypted text: %s\n", plaintext);

    return 0;
}
