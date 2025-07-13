# AES File Encryption & Decryption Tool

This project is a file encryption and decryption application utilizing **symmetric key cryptography**. It was developed as part of the "Introduction to Cybersecurity" course.

## Features

- 🔐 **Symmetric AES encryption** using ECB, CBC, and CTR modes
- 🧪 Real-time encryption and decryption of local files
- 🔑 Password-based key derivation using PBKDF2 with HMAC-SHA256
- 📂 Simple GUI with options to:
  - Select a file
  - Enter a password
  - Choose encryption mode (ECB, CBC, CTR)
  - Encrypt or decrypt files
- 📄 Output files:
  - Encrypted files: `filename.enc`
  - Decrypted files: `filename.dec`

## Encryption Modes

| Mode | Parallel | Pattern Resistance | Error Propagation | Notes |
|------|----------|--------------------|-------------------|-------|
| ECB  | ✅        | ❌                  | 🔁 block only      | Fast but insecure for structured data |
| CBC  | ❌        | ✅                  | 🔁 2 blocks        | Good for structured data, uses IV |
| CTR  | ✅        | ✅                  | 🔁 byte-level      | Stream-like, ideal for unstable channels |

## Key Management

- **Key Generation:** Secure AES key (128-bit) is derived from user password using PBKDF2.
- **Key Exchange:** Assumes the key (password) is shared securely; external protocols like Diffie-Hellman are recommended for production use.

## Error Handling

The app includes functionality to simulate data corruption by modifying random bytes in encrypted files. The effects on decryption differ depending on the mode:
- **ECB:** One corrupted byte distorts an entire block
- **CBC:** Affects two blocks
- **CTR:** Affects only the exact byte

## Getting Started

1. Clone the repository
2. Run the application.
3. Select the file to encrypt or decrypt.
4. Enter your password.
5. Choose the AES mode.
6. Click "Encrypt" or "Decrypt".

> ⚠️ Use strong passwords. Weak or predictable passwords significantly reduce security.

### Viewing Decrypted Images

If you decrypted an image originally saved as PPM (binary), you can view the output `.dec` file using the provided **Python script [`display_img.py`](examples/display_img.py)**:

1. **Make sure the decryption was successful** — the correct password and AES mode must be used.
2. Use preffered IDE or bash:   
```bash
pip install imageio matplotlib
python display_img.py filename.dec
```


## More Information

For a detailed explanation of encryption theory, mode comparison, error propagation, and implementation specifics (all in Polish) **please refer to [`dokumentacja.pdf`](./dokumentacja.pdf)**.

