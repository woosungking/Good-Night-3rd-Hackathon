import axios from 'axios';
import { CreatedWish } from '../interface/Wish';

export const createWish = (wish: CreatedWish) => {
  try {
    const response = axios.post(
      'http://localhost:8080/api/v1/wish/create',
      wish,
      {
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      },
    );
    return response;
  } catch (error) {
    console.log(
      '소원을 저장하는 도중 오류가 발생하였습니다 ERROR ::: => ',
      error,
    );
  }
};

export const getAllWish = async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/wish/list');
    return response.data.data;
  } catch (error) {
    console.log(
      '소원 리스트를 불러 오는 도중 오류가 발생하였습니다 ::: =>',
      error,
    );
  }
};

export const getWish = async (id: number) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/v1/wish/${id}`);
    return response.data.data;
  } catch (error) {
    console.log(
      `소원 아이디 ${id}를 조회하는 도중 오류가 발생하였습니다 ::: =>`,
      error,
    );
  }
};

export const deleteWish = async (id: number) => {
  try {
    const response = await axios.delete(
      `http://localhost:8080/api/v1/wish/delete/${id}`,
    );
    console.log(response.data);
  } catch (error) {
    console.log(
      `소원 아이디 ${id}를 삭제하는 도중 오류가 발생하였습니다 ::: =>`,
      error,
    );
  }
};

export const patchWish = async (id: number, confirm: boolean) => {
  try {
    const response = await axios.patch(
      `http://localhost:8080/api/v1/wish/approval/${id}`, // 슬래시 수정
      { confirm: confirm },
      {
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      },
    );
    console.log(`소원 ID ${id} ${confirm ? '승인됨' : '거절됨'}.`);
  } catch (error) {
    console.error('Error confirming wish:', error);
  }
};
