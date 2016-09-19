import React from 'react'

import {
    Text,
    View,
} from 'react-native'

import Button from 'ares/app/components/Button'

import {DefaultHeadBar} from 'ares/app/features/head_bar'

import SendIntentAndroid from 'react-native-send-intent'

export default class Features extends React.Component {
  render() {
    console.log(this.props.navigator.getCurrentRoutes())

    return(
      <View>
        <DefaultHeadBar navigator={this.props.navigator} title="非业务功能列表"/>
        <Button
          text="二维码生成"
          onPress={()=> this.props.navigator.push({id: "qrcode_gen", params: []})}
          />
        <Button
          text="二维码扫描(未实现)"
          />
        <Button
          text="分享(未实现)"
          />
      </View>
    )
  }
}