import argparse
from random import randint

def corrupt_file(input_file, output_file, num_mods):
    with open(input_file, "rb") as f:
        data = bytearray(f.read())

    for _ in range(num_mods):
        idx = randint(100, len(data) - 101)
        data[idx] = 0xFF

    with open(output_file, "wb") as f:
        f.write(data)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Corrupt a file by randomly setting bytes to 0xFF.")
    parser.add_argument("input_file", help="Path to the input .enc file")
    parser.add_argument("output_file", help="Path to the output .enc file")
    parser.add_argument("num_mods", type=int, help="Number of random modifications to apply")

    args = parser.parse_args()

    corrupt_file(args.input_file, args.output_file, args.num_mods)
