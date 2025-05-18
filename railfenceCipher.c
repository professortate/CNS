#include <stdio.h> 
#include <string.h> 
#include <ctype.h> 
#define MAX_TEXT_LENGTH 1000 
void encryptRailFence(char *plaintext, int key) { 
int plaintextLength = strlen(plaintext); 
char rail[key][plaintextLength]; 
for (int i = 0; i < key; i++) { 
for (int j = 0; j < plaintextLength; j++) { 
rail[i][j] = '\n'; 
} 
} 
int row = 0; 
int direction = 0; 
for (int i = 0; i < plaintextLength; i++) { 
rail[row][i] = plaintext[i]; 
if (row == 0 || row == key - 1) { 
direction = !direction; 
} 
row += direction ? 1 : -1; 
} 
printf("Encrypted text: "); 
for (int i = 0; i < key; i++) { 
for (int j = 0; j < plaintextLength; j++) { 
if (rail[i][j] != '\n') { 
printf("%c", rail[i][j]); 
} 
} 
} 
printf("\n"); 
} 
void decryptRailFence(char *ciphertext, int key) { 
int ciphertextLength = strlen(ciphertext); 
char rail[key][ciphertextLength]; 
for (int i = 0; i < key; i++) { 
for (int j = 0; j < ciphertextLength; j++) { 
rail[i][j] = '\n'; 
} 
} 
int row = 0; 
int direction = 0; 
for (int i = 0; i < ciphertextLength; i++) { 
rail[row][i] = '*'; 
if (row == 0 || row == key - 1) { 
direction = !direction; 
} 
row += direction ? 1 : -1; 
} 
int index = 0; 
for (int i = 0; i < key; i++) { 
for (int j = 0; j < ciphertextLength; j++) { 
if (rail[i][j] == '*' && index < ciphertextLength) { 
rail[i][j] = ciphertext[index++]; 
} 
} 
} 
printf("Decrypted text: "); 
row = 0; 
direction = 0; 
for (int i = 0; i < ciphertextLength; i++) { 
printf("%c", rail[row][i]); 
if (row == 0 || row == key - 1) { 
direction = !direction; 
} 
row += direction ? 1 : -1; 
} 
printf("\n"); 
} 
int main() { 
char plaintext[MAX_TEXT_LENGTH]; 
int key; 
printf("Enter plaintext: "); 
fgets(plaintext, sizeof(plaintext), stdin); 
plaintext[strcspn(plaintext, "\n")] = '\0'; // Remove newline character 
printf("Enter key: "); 
scanf("%d", &key); 
encryptRailFence(plaintext, key); 
decryptRailFence(plaintext, key); 
return 0; 
} 