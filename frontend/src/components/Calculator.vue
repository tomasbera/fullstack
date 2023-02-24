<template>
  <div class="calculator">
      <div class="grid">
        <div class="box a">{{ curr_eq || '0'}}</div>
        <div class="box b functions" @click="clear()">C</div>
        <div class="box c functions" @click="lastANS()">ANS</div>
        <div class="box d functions" @click="delSingle()">DEL</div>
        <div class="box e operation" @click="addition()">+</div>
        <div class="box f" @click="add('1')">1</div>
        <div class="box g" @click="add('2')">2</div>
        <div class="box h" @click="add('3')">3</div>
        <div class="box i operation" @click="subtraction()">-</div>
        <div class="box j" @click="add('4')">4</div>
        <div class="box k" @click="add('5')">5</div>
        <div class="box l" @click="add('6')">6</div>
        <div class="box m operation" @click="multiplication()">*</div>
        <div class="box o" @click="add('7')">7</div>
        <div class="box p" @click="add('8')">8</div>
        <div class="box q" @click="add('9')">9</div>
        <div class="box r operation" @click="division()">/</div>
        <div class="box zero" @click="add('0')">0</div>
        <div class="box o" @click="add_dote()">.</div>
        <div class="box v operation" @click="answer()">=</div>
      </div>
    </div>
</template>

<script>
import * as calculator from "@/services/Calculator"

export default {
  data() {
    return {
      curr_eq: "0",
      prev_eq: null,
      operator: null,
      operatorClicked: false,
      prevOp: null,
      equation: ''
      }
    },
  methods: {
    clear() {
      this.prev_eq = this.curr_eq;
      this.curr_eq = '0';
      this.operator = null;
      this.operatorClicked = false;
      this.onClear();
    },
    lastANS() {
      if (this.prev_eq !== null) {
        this.add(this.prev_eq);
      } else this.add('0');
    },

    delSingle() {
      if (this.curr_eq !== '0') this.curr_eq = this.curr_eq.slice(0, -1)
    },

    add(number) {
      if (this.operatorClicked) {
        this.curr_eq = '';
        this.operatorClicked = false;
      }
      if (this.curr_eq === '0') {
        this.curr_eq = `${number}`;
      } else {
        this.curr_eq = `${this.curr_eq}${number}`;
      }
    },

    add_dote() {
      if (this.curr_eq === '0') {
        this.add('0.')
      }
      if (this.curr_eq.indexOf('.') === -1) {
        this.add('.');
      }
    },

    setPrev(operator) {
      this.prev_eq = this.curr_eq;
      this.operatorClicked = true;
      this.prevOp = operator
    },

    multiplication() {
      this.operator = (a, b) => a * b;
      this.setPrev("*");
    },

    division() {
      this.operator = (a, b) => a / b;
      this.setPrev("/");
    },

    subtraction() {
      this.operator = (a, b) => a - b;
      this.setPrev("-");
    },

    addition() {
      this.operator = (a, b) => a + b;
      this.setPrev("+");
    },

    async answer() {
      if (isFinite(parseFloat(this.prev_eq) / parseFloat(this.curr_eq))) {
        await calculator.postCalculation({
          numb1: parseFloat(this.prev_eq),
          numb2: parseFloat(this.curr_eq),
          operator: this.prevOp
        });
        this.curr_eq = await calculator.getAnswer();
        await this.onSubmit();
        this.prev_eq = null;
      } else {
        this.onError("Division By Zero is Bad")
      }
    },

    async onSubmit() {
      this.$store.dispatch(`addToLog`, await calculator.getLog());
    },

    onClear() {
      this.$store.dispatch(`clearLog`);
    },

  },
}

</script>


<style scoped>

html {
  font-size: 14px;
  font-family: 'Oxygen', sans-serif;
  background-color: #f9f9f9;
}

/*BODY*/
body {
  text-align: center;
  align-content: center;
}
.calculator {
  border: 5px solid;
  margin: 50px auto;
  width: 300px;
  padding: 10px;
  height: 250px;
  background-color: darkslategrey;
}

/*GRID*/
.grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-template-rows: repeat(9, 1fr);
  gap: 5px;
}

.box {
  font-size: 20px;
  background-color: black;
  color: white;
  border-radius: 5px;
  border: 2px;
  text-align: justify-all;
  min-height: 30px;
}

.box:hover {
  background-color: orangered;
}

.a {
  font-size: 30px;
  border-radius: 0;
  text-align: center;
  background-color: #282828;
  grid-column: 1/span 4;
}

.zero {
  grid-column: 1/span 2;
}

.functions {
  background-color: orange;
}

.operation {
  background-color: #4c7ef3;
}

</style>
