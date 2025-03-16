import json
import matplotlib.pyplot as plt
import os
import sys

sys.set_int_max_str_digits(100000)

class Graph_plotter:
    def __init__(self, file_paths):
        self.file_paths = file_paths
        self.data = []

    def read_json_data(self):
        for file_path in self.file_paths:
            with open(file_path, 'r') as file:
                self.data.append(json.load(file))

    def create_graph(self):
        for data in self.data:
            numbers = [entry["Number"] for entry in data]
            execution_times = [entry["ExecutionTime"] for entry in data]

            plt.plot(numbers, execution_times, marker='o')

        plt.title('Execution Time vs Number')
        plt.xlabel('Number')
        plt.ylabel('Execution Time (ns)')
        plt.legend([os.path.basename(fp) for fp in self.file_paths], loc="upper left")
        plt.show()

file_paths = [
    r"X:\Onedrive\Dokumenter\Høgskolen i Østfold\4.Semster\II.2415 Advanced Algorithmic & Programming\Assignments\Assingment 2\Output\mergeSortIterativeTimes.json",
    r"X:\Onedrive\Dokumenter\Høgskolen i Østfold\4.Semster\II.2415 Advanced Algorithmic & Programming\Assignments\Assingment 2\Output\mergeSortRecursiveTimes.json"
]

plotter = Graph_plotter(file_paths)

plotter.read_json_data()
plotter.create_graph()

file_paths = [
    r"X:\Onedrive\Dokumenter\Høgskolen i Østfold\4.Semster\II.2415 Advanced Algorithmic & Programming\Assignments\Assingment 2\Output\quickSortRecursiveTimes.json"
    
]

plotter = Graph_plotter(file_paths)

plotter.read_json_data()
plotter.create_graph()

file_paths = [
    r"X:\Onedrive\Dokumenter\Høgskolen i Østfold\4.Semster\II.2415 Advanced Algorithmic & Programming\Assignments\Assingment 2\Output\radixSortTimes.json"
]

plotter = Graph_plotter(file_paths)

plotter.read_json_data()
plotter.create_graph()