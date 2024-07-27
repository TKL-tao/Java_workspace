import sys

def main():
    if len(sys.argv) != 3:
        print("Usage: python script.py <param1> <param2>")
        return
    
    param1 = sys.argv[1]
    param2 = sys.argv[2]
    
    result = f"Received parameters: {param1} and {param2}"
    print(result)

if __name__ == "__main__":
    main()