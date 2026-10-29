package pl.bsjhx.katas.designpatterns.composite;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FileTest {

    @Test
    void should_print_file() {
        var file = File.file("file.txt", 100);

        assertThat(file.print("")).isEqualTo("file.txt (100 bytes)");
        assertThat(file.print("\t")).isEqualTo("\tfile.txt (100 bytes)");
        assertThat(file.print("     ")).isEqualTo("     file.txt (100 bytes)");
    }
}