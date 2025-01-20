import React, { useState } from 'react';
import { View, Text, Button, StyleSheet } from 'react-native';
import { NativeModules } from 'react-native';

const { MyNativeModule } = NativeModules;

const App = () => {
  const [message, setMessage] = useState('');

  const fetchDataFromNative = async () => {
    try {
      const data = await MyNativeModule.getData();
      console.log('data', data);
      setMessage(`Received: ${JSON.stringify(data)}`);
    } catch (error) {
      console.log('error', error);


      setMessage(`Error: ${error.message}`);
    }
  };

  return (
    <View style={styles.container}>
      <Button title="Fetch Data from Kotlin" onPress={fetchDataFromNative} />
      <Text style={styles.message}>{message}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 16,
  },
  message: {
    marginTop: 20,
    fontSize: 16,
    textAlign: 'center',
  },
});

export default App;
