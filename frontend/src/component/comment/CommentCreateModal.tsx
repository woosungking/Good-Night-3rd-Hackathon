import React, { useEffect } from 'react';

import post from '../../assets/post.png';

interface CommentModalProps {
  showModal: boolean;
  onClose: () => void;
  commentValue: string;
  onInput: () => void;
  onSubmit: () => void;
}

const CommentModal: React.FC<CommentModalProps> = ({
  showModal,
  onClose,
  commentValue,
  onInput,
  onSubmit,
}) => {
  return (
    <div className="absolute top-[20%] left-[10%] w-[500px] h-[500px]">
      <img className="absolute object-cover" src={post} alt="Post" />
      <input
        className="absolute mt-[10vh] ml-[20%] w-[60%] h-[50%] bg-white bg-opacity-0 z-5"
        value={commentValue}
        onChange={onInput}
      />
      <button
        className="absolute w-[100px] bottom-[20%] right-[53%]"
        onClick={onSubmit}
      >
        작성
      </button>
      <button
        className="absolute w-[100px] bottom-[20%] right-[26%]"
        onClick={onClose}
      >
        취소
      </button>
    </div>
  );
};

export default CommentModal;
